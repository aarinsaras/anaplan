/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.message.processor;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.accenture.client.anaplan.entity.Customer;
import org.accenture.client.anaplan.parser.csv.CsvParser;
import org.accenture.client.anaplan.repository.CustomerRepository;
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
public class CustomerProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(ProductProcessor.class);
       
    @Autowired
    private CustomerRepository customerRepository;
   
    private static final String[] FILE_HEADER_MAPPING = {"row", "custId", "custfname", "custlname", "businessPhone", "personalPhone"};
    
    @Override
    public void process(Exchange exchng) throws Exception {
        List<CSVRecord> cSVRecords = new CsvParser().parse(new StringReader(exchng.getIn().getBody().toString()), FILE_HEADER_MAPPING);
        for(CSVRecord record : cSVRecords) {
            Customer customer = Customer.buildCustomerInstance().setCustId(Integer.valueOf(record.get(FILE_HEADER_MAPPING[1])))
                    .setCustFName(record.get(FILE_HEADER_MAPPING[2]))
                    .setCustLName(record.get(FILE_HEADER_MAPPING[3]))
                    .setCustPhone(new HashSet<>(Arrays.asList(new Integer[] {Integer.valueOf(record.get(FILE_HEADER_MAPPING[4])), 
                        Integer.valueOf(record.get(FILE_HEADER_MAPPING[5]))})))
                    .setTimestamp(new Date());
            try {
                customerRepository.insert(customer);
                LOG.error("Successfully inserted customer : " + customer.toString());
            } catch(Exception e) {
                e.printStackTrace();
                LOG.error("Error inserting product : " + customer.toString());
            }
        }
    }
    
}
