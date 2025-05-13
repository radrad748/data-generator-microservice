package com.data.generator.microservice.service;

import com.data.generator.microservice.model.test.DataTestOptions;


public interface TestDataService {
    void sendMessages(DataTestOptions dataTestOptions);
}
