/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.entity;

import java.util.Date;
import java.util.Set;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 *
 * @author prajwal.ravishankar
 */
@Table
public class Customer implements Entity {
    
    @PrimaryKey
    private Integer custId;
    
    private String custFName;
    
    private String custLName;
    
    private Set<Integer> custPhone;
    
    private Date timestamp;

    public Integer getCustId() {
        return custId;
    }

    public Customer setCustId(Integer custId) {
        this.custId = custId;
        return this;
    }

    public String getCustFName() {
        return custFName;
    }

    public Customer setCustFName(String custFName) {
        this.custFName = custFName;
        return this;
    }

    public String getCustLName() {
        return custLName;
    }

    public Customer setCustLName(String custLName) {
        this.custLName = custLName;
        return this;
    }

    public Set<Integer> getCustPhone() {
        return custPhone;
    }

    public Customer setCustPhone(Set<Integer> custPhone) {
        this.custPhone = custPhone;
        return this;
    }
    
    public static Customer buildCustomerInstance() {
        return new Customer();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Customer setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        return "Customer Id : " + custId + ", Cust Fname : " + custFName;
    }
    
    
}
