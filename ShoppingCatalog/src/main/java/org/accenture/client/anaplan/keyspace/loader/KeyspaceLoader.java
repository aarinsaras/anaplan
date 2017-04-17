/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.keyspace.loader;

import org.accenture.client.anaplan.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keyspace")
public class KeyspaceLoader {
    
    @Autowired
    private CrudRepository crudRepository;
    
    @RequestMapping(method = RequestMethod.GET, value = "/createKeySpaceAndTables")
    public void createKeyspaceAndTables(@RequestParam String query) throws Exception {
        crudRepository.executeQuery(query);
    }
}
