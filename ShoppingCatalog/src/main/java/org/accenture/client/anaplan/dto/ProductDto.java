/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.dto;

import java.util.List;
import org.accenture.client.anaplan.entity.Product;

/**
 *
 * @author prajwal.ravishankar
 */
public class ProductDto {
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public ProductDto setProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }
    
}
