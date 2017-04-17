/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.repository;

import org.accenture.client.anaplan.entity.Customer;
import org.accenture.client.anaplan.entity.Entity;
import org.springframework.stereotype.Component;

/**
 *
 * @author prajwal.ravishankar
 */
@Component
public class CustomerRepository extends CrudRepository {
    
    public Entity findCustomerById(Integer id) {
        return findById(Customer.class, id);
   }
    
}
