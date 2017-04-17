/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.dto;

import java.util.List;
import org.accenture.client.anaplan.entity.Customer;

/**
 *
 * @author prajwal.ravishankar
 */
public class CustomerDto {
    
    private List<Customer> customerList;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public CustomerDto setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
        return this;
    }
    
}
