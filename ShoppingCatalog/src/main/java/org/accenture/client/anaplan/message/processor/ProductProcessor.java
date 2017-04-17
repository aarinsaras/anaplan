/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.message.processor;

import java.io.StringReader;
import java.util.Date;
import java.util.List;
import org.accenture.client.anaplan.entity.Product;
import org.accenture.client.anaplan.parser.csv.CsvParser;
import org.accenture.client.anaplan.repository.ProductRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author prajwal.ravishankar
 */
@Component
public class ProductProcessor implements Processor {
    
    private static final Logger LOG = LoggerFactory.getLogger(ProductProcessor.class);
       
    @Autowired
    private ProductRepository productRepository;
   
    private static final String[] FILE_HEADER_MAPPING = {"row", "productId", "productName", "category"};

    @Override
    public void process(Exchange exchng) throws Exception {
        List<CSVRecord> cSVRecords = new CsvParser().parse(new StringReader(exchng.getIn().getBody().toString()), FILE_HEADER_MAPPING);
        for(CSVRecord record : cSVRecords) {
            Product product = Product.buildProductsInstance().setProductId(Integer.valueOf(record.get(FILE_HEADER_MAPPING[1])))
                    .setProductName(record.get(FILE_HEADER_MAPPING[2]))
                    .setCategory(record.get(FILE_HEADER_MAPPING[3]))
                    .setTimestamp(new Date());
            try {
                productRepository.insert(product);
                LOG.error("Successfully inserted product : " + product.toString());
            } catch(Exception e) {
                e.printStackTrace();
                LOG.error("Error inserting product : " + product.toString());
            }
        }
    }
    
}
