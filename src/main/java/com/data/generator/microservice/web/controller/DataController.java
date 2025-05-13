package com.data.generator.microservice.web.controller;

import com.data.generator.microservice.model.Data;
import com.data.generator.microservice.model.test.DataTestOptions;
import com.data.generator.microservice.service.KafkaDataService;
import com.data.generator.microservice.service.TestDataService;
import com.data.generator.microservice.web.dto.DataDto;
import com.data.generator.microservice.web.dto.DataTestOptionsDto;
import com.data.generator.microservice.web.mapper.DataMapper;
import com.data.generator.microservice.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;

    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;


    @PostMapping("/send")
    public void send(@RequestBody DataDto dto) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);

    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }

}
