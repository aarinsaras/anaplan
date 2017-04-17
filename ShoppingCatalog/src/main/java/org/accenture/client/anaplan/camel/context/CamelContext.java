/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.camel.context;

import org.accenture.client.anaplan.message.processor.CustomerOrderProductProcessor;
import org.accenture.client.anaplan.message.processor.CustomerProcessor;
import org.accenture.client.anaplan.message.processor.ProductProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author prajwal.ravishankar
 */
@Component
public class CamelContext {
    
     private static final Logger LOG = LoggerFactory.getLogger(CamelContext.class);
    
    @Autowired
    private org.apache.camel.CamelContext camelContext;
    
    @Autowired
    private ProductProcessor productProcessor;
    
    @Autowired
    private CustomerProcessor customerProcessor;
    
    @Autowired
    private CustomerOrderProductProcessor customerOrderProductProcessor;
        
    public void processMessages(final String filePath, final String fileName, final String queueName) throws Exception {
        camelContext.addRoutes(new RouteBuilder(){
            @Override
            public void configure() throws Exception {
                from("file:" + filePath + "?fileName=" + fileName + "&noop=true")
                .convertBodyTo(String.class)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchng) throws Exception {
                        LOG.info(exchng.getIn().getBody().toString());
                    }
                })
                .to("jms:" + queueName);
                               
                if(fileName.equalsIgnoreCase("products.csv")) {
                    LOG.info(fileName + " routed to " + queueName);
                    from("jms:" + queueName).errorHandler(defaultErrorHandler().maximumRedeliveries(3).redeliveryDelay(0))
                            .process(productProcessor);
                } else if(fileName.equalsIgnoreCase("customers.csv")){
                    LOG.info(fileName + " routed to " + queueName);
                    from("jms:" + queueName).errorHandler(defaultErrorHandler().maximumRedeliveries(3).redeliveryDelay(0))
                            .process(customerProcessor).to("log:foo");
                } else if(fileName.equalsIgnoreCase("customerorderproducts.csv")){
                    LOG.info(fileName + " routed to " + queueName);
                    from("jms:" + queueName).errorHandler(defaultErrorHandler().maximumRedeliveries(3).redeliveryDelay(0))
                            .process(customerOrderProductProcessor).to("log:foo");
                }
                
            }
        });
    }
}
