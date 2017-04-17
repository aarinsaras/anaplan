/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.rest.controller;

import java.util.Arrays;
import java.util.List;
import org.accenture.client.anaplan.dto.CustomerDto;
import org.accenture.client.anaplan.entity.Customer;
import org.accenture.client.anaplan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author prajwal.ravishankar
 */
@RestController
@RequestMapping("/getCustomer")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody CustomerDto getAll() throws Exception {
        List<Customer> list = customerRepository.findAll(Customer.class);
        return new CustomerDto().setCustomerList(list);
    } 
    
    @RequestMapping(method = RequestMethod.GET, value = "/getCustomerById/{custId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody CustomerDto getCustomerById(@PathVariable Integer custId) throws Exception {
        Customer customer = (Customer)customerRepository.findCustomerById(custId);
        return new CustomerDto().setCustomerList(Arrays.asList(new Customer[] {customer}));
    } 
}
