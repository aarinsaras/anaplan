/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.dto;

import org.accenture.client.anaplan.entity.Customer;
import org.accenture.client.anaplan.entity.CustomerOrderProduct;
import org.accenture.client.anaplan.entity.Product;

/**
 *
 * @author prajwal.ravishankar
 */
public class CustomerOrderProductDto {
    
    private CustomerOrderProduct customerOrderProduct;
    
    private Customer customer;
    
    private Product product;

    public CustomerOrderProduct getCustomerOrderProduct() {
        return customerOrderProduct;
    }

    public CustomerOrderProductDto setCustomerOrderProduct(CustomerOrderProduct customerOrderProduct) {
        this.customerOrderProduct = customerOrderProduct;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerOrderProductDto setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public CustomerOrderProductDto setProduct(Product product) {
        this.product = product;
        return this;
    }
    
}
