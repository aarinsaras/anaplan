/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.rest.controller;

import org.accenture.client.anaplan.camel.context.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author prajwal.ravishankar
 */
@RestController
@RequestMapping("/processMessage")
public class CsvMessageController {
    
    @Autowired
    private CamelContext camelContext;
    
    @RequestMapping(method = RequestMethod.GET, value = "/csv")
    public void processCSVMessage(@RequestParam String filePath, @RequestParam String fileName, @RequestParam String queueName) throws Exception {
        camelContext.processMessages(filePath, fileName, queueName);
    }    
    
}
