package com.data.generator.microservice.web.mapper;

import com.data.generator.microservice.model.test.DataTestOptions;
import com.data.generator.microservice.web.dto.DataTestOptionsDto;
import org.springframework.stereotype.Component;

@Component
public class DataTestOptionsMapper implements Mappable<DataTestOptions, DataTestOptionsDto> {
    @Override
    public DataTestOptions toEntity(DataTestOptionsDto dto) {
        DataTestOptions options = new DataTestOptions();
        options.setDelayInSeconds(dto.getDelayInSeconds());
        options.setMeasurementTypes(dto.getMeasurementTypes());

        return options;
    }

    @Override
    public DataTestOptionsDto toDto(DataTestOptions entity) {
        DataTestOptionsDto dto = new DataTestOptionsDto();
        dto.setDelayInSeconds(entity.getDelayInSeconds());
        dto.setMeasurementTypes(entity.getMeasurementTypes());

        return dto;
    }
}
