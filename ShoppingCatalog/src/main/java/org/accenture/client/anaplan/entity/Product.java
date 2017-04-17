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
public class Product implements Entity {
    @PrimaryKey
    private Integer productId;
    
    private String productName;
    
    private String category;
    
    private Date timestamp;

    public Integer getProductId() {
        return productId;
    }

    public Product setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Product setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    
    public static Product buildProductsInstance() {
        return new Product();
    }
   
    @Override
    public String toString() {
        return "Product Id : " + productId + ": Product Name : " + productName;
    }
    
}
