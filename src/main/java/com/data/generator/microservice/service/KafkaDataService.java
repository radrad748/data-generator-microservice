package com.data.generator.microservice.service;

import com.data.generator.microservice.model.Data;

public interface KafkaDataService {
    void send(Data data);
}
