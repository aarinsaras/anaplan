/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.rest.controller;

import java.util.ArrayList;
import java.util.List;
import org.accenture.client.anaplan.dto.CustomerOrderProductDto;
import org.accenture.client.anaplan.entity.Customer;
import org.accenture.client.anaplan.entity.CustomerOrderProduct;
import org.accenture.client.anaplan.entity.Product;
import org.accenture.client.anaplan.repository.CustomerOrderRepository;
import org.accenture.client.anaplan.repository.CustomerRepository;
import org.accenture.client.anaplan.repository.ProductRepository;
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
@RequestMapping("/getCustomerOrders")
public class CustomerOrderController {
    
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<CustomerOrderProductDto> getAll() throws Exception {
        
        List<CustomerOrderProductDto> customerOrderProductDtos = new ArrayList<>();
        
        List<CustomerOrderProduct> customerOrderProducts = customerOrderRepository.findAll(CustomerOrderProduct.class);
                
        for(CustomerOrderProduct customerOrderProduct : customerOrderProducts) {
            Integer custId = customerOrderProduct.getCustId();
            Integer productId = customerOrderProduct.getProductId();
            Product product = (Product)productRepository.findProductById(productId);
            Customer customer = (Customer)customerRepository.findCustomerById(custId);
            customerOrderProductDtos.add(new CustomerOrderProductDto().setCustomerOrderProduct(customerOrderProduct).setCustomer(customer).setProduct(product));
        }
        
        return customerOrderProductDtos;
    } 

    @RequestMapping(method = RequestMethod.GET, value = "/getOrderById/{orderId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody CustomerOrderProductDto getOrderById(@PathVariable Integer orderId) throws Exception {
        CustomerOrderProduct customerOrderProduct = (CustomerOrderProduct)customerOrderRepository.findOrderById(orderId);
        Product product = (Product)productRepository.findProductById(customerOrderProduct.getProductId());
        Customer customer = (Customer)customerRepository.findCustomerById(customerOrderProduct.getCustId());
        return new CustomerOrderProductDto().setCustomer(customer).setProduct(product).setCustomerOrderProduct(customerOrderProduct);
    }
    
}
