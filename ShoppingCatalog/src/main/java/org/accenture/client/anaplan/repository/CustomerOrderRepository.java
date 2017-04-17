/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.repository;

import org.accenture.client.anaplan.entity.CustomerOrderProduct;
import org.accenture.client.anaplan.entity.Entity;
import org.springframework.stereotype.Component;

/**
 *
 * @author prajwal.ravishankar
 */
@Component
public class CustomerOrderRepository extends CrudRepository {
    
    public Entity findOrderById(Integer id) {
        return findById(CustomerOrderProduct.class, id);
   }
}
