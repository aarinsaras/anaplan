/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.message.processor;

import java.io.StringReader;
import java.util.Date;
import java.util.List;
import org.accenture.client.anaplan.entity.CustomerOrderProduct;
import org.accenture.client.anaplan.parser.csv.CsvParser;
import org.accenture.client.anaplan.repository.CustomerOrderRepository;
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
public class CustomerOrderProductProcessor implements Processor {
    
    private static final Logger LOG = LoggerFactory.getLogger(CustomerOrderProductProcessor.class);
    
     private static final String[] FILE_HEADER_MAPPING = {"row","orderId", "custId", "productId", "orderstate", "noofitems"};
       
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public void process(Exchange exchng) throws Exception {
        List<CSVRecord> cSVRecords = new CsvParser().parse(new StringReader(exchng.getIn().getBody().toString()), FILE_HEADER_MAPPING);
        for(CSVRecord record : cSVRecords) {
            CustomerOrderProduct customerOrderProduct = CustomerOrderProduct.buildCustomerOrderProductInstance()
                    .setOrderId(Integer.valueOf(record.get(FILE_HEADER_MAPPING[1])))
                    .setCustId(Integer.valueOf(record.get(FILE_HEADER_MAPPING[2])))
                    .setProductId(Integer.valueOf(record.get(FILE_HEADER_MAPPING[3])))
                    .setOrderState(record.get(FILE_HEADER_MAPPING[4]))
                    .setNoOfItems(Integer.valueOf(record.get(FILE_HEADER_MAPPING[5])))
                    .setOrderPlacedDate(new Date());
            try {
                customerOrderRepository.insert(customerOrderProduct);
                LOG.error("Successfully inserted customer order : " + customerOrderProduct.toString());
            } catch(Exception e) {
                e.printStackTrace();
                LOG.error("Error inserting customer order : " + customerOrderProduct.toString());
            }
        }
    }
    
}
