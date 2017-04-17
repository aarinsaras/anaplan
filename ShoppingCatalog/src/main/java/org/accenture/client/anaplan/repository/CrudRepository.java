/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.repository;

import com.datastax.driver.core.ResultSet;
import java.util.List;
import org.accenture.client.anaplan.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

/**
 *
 * @author prajwal.ravishankar
 */
@Component
public class CrudRepository implements Repository<Entity> {
    
    @Autowired
    CassandraOperations cassandraTemplate; 

    @Override
    public void delete(Entity entity) {
        cassandraTemplate.delete(entity);
    }

    @Override
    public List findAll(Class entity) {
        return cassandraTemplate.selectAll(entity);
    }

    @Override
    public Entity update(Entity entity) {
        return cassandraTemplate.update(entity);
    }

    @Override
    public Entity insert(Entity entity) {
        return cassandraTemplate.insert(entity);
    }

    @Override
    public Long count(Class<Entity> entity) {
        return cassandraTemplate.count(entity);
    }

    @Override
    public ResultSet executeQuery(String query) {
        return cassandraTemplate.getSession().execute(query);
    }

    @Override
    public Entity findById(Class entity, Integer id) {
        return (Entity)cassandraTemplate.selectOneById(entity, id);
    }
   
}
