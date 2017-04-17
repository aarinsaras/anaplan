/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.repository;

import com.datastax.driver.core.ResultSet;
import java.util.List;

/**
 *
 * @author prajwal.ravishankar
 */
public interface Repository<T> {
    
    public static final String USE_SESSION = "SHOPPINGCATALOG";
    
    public T insert(T entity);
    
    public void delete(T entity);
    
    public T update(T entity);
    
    public List<T> findAll(Class<T> entity);
    
    public Long count(Class<T> entity);
    
    public ResultSet executeQuery(String query);
    
    public T findById(Class<T> entity, Integer id);
   
}
