/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.rest.controller;

import java.util.Arrays;
import java.util.List;
import org.accenture.client.anaplan.dto.ProductDto;
import org.accenture.client.anaplan.entity.Product;
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
@RequestMapping("/getProduct")
public class ProductsController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ProductDto getAll() throws Exception {
        List<Product> list = productRepository.findAll(Product.class);
        return new ProductDto().setProductList(list);
    } 
   
    @RequestMapping(method = RequestMethod.GET, value = "/getProductById/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ProductDto getProductById(@PathVariable Integer productId) throws Exception {
        Product product = (Product)productRepository.findProductById(productId);
        return new ProductDto().setProductList(Arrays.asList(new Product[] {product}));
    } 
}
