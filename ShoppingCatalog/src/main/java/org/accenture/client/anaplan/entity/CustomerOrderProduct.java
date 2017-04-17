/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.entity;

import java.util.Date;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 *
 * @author prajwal.ravishankar
 */
@Table
public class CustomerOrderProduct implements Entity{
    
    @PrimaryKey
    private Integer orderId;
    private Integer custId;
    private Integer productId;
    private Date orderPlacedDate;
    private String orderState;
    private Integer noOfItems;

    public Integer getOrderId() {
        return orderId;
    }

    public CustomerOrderProduct setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getCustId() {
        return custId;
    }

    public CustomerOrderProduct setCustId(Integer custId) {
        this.custId = custId;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public CustomerOrderProduct setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Date getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public CustomerOrderProduct setOrderPlacedDate(Date orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
        return this;
    }

    public String getOrderState() {
        return orderState;
    }

    public CustomerOrderProduct setOrderState(String orderState) {
        this.orderState = orderState;
        return this;
    }

    public Integer getNoOfItems() {
        return noOfItems;
    }

    public CustomerOrderProduct setNoOfItems(Integer noOfItems) {
        this.noOfItems = noOfItems;
        return this;
    }
    
    public static CustomerOrderProduct buildCustomerOrderProductInstance() {
        return new CustomerOrderProduct();
    }

    @Override
    public String toString() {
        return "Order Id : " + orderId + " , Customer Id : " + custId;
    }
    
    
}
