/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author prajwal.ravishankar
 */
@Configuration()
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"org.accenture.client.anaplan.camel.context",
    "org.accenture.client.anaplan.rest.controller",
    "org.accenture.client.anaplan.mvc.controller",
    "org.accenture.client.anaplan.entity",
    "org.accenture.client.anaplan.keyspace.loader",
    "org.accenture.client.anaplan.message.processor",
    "org.accenture.client.anaplan.repository"})
@ImportResource(value = {"cassandraContext.xml", "camelContext.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplicationExample {
    public static void main(String args[]) {
        //System.setProperty("spring.devtools.restart.enabled", "false");
        //System.setProperty("spring.config.name", "app.properties");
        SpringApplication.run(SpringBootApplicationExample.class, args);
    }
}
