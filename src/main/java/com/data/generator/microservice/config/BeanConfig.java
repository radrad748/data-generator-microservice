package com.data.generator.microservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Configuration
public class BeanConfig {

    @Bean
    public XML producerXML() throws IOException {
        return new XMLDocument(
                getClass().getResourceAsStream("/kafka/producer.xml").readAllBytes()
        );
        //return new XMLDocument(new File("src/main/resources/kafka/producer.xml"));
    }

}
