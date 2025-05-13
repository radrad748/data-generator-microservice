package com.data.generator.microservice.web.mapper;

import com.data.generator.microservice.model.Data;
import com.data.generator.microservice.web.dto.DataDto;
import org.springframework.stereotype.Component;


//@Mapper(componentModel = "spring")
@Component
public class DataMapper implements Mappable<Data, DataDto> {


    @Override
    public Data toEntity(DataDto dto) {
        Data data = new Data();
        data.setSensorId(dto.getSensorId());
        data.setTimestamp(dto.getTimestamp());
        data.setMeasurement(dto.getMeasurement());
        data.setMeasurementType(dto.getMeasurementType());

        return data;
    }

    @Override
    public DataDto toDto(Data entity) {
        DataDto dataDto = new DataDto();
        dataDto.setSensorId(entity.getSensorId());
        dataDto.setTimestamp(entity.getTimestamp());
        dataDto.setMeasurement(entity.getMeasurement());
        dataDto.setMeasurementType(entity.getMeasurementType());

        return dataDto;
    }
}
