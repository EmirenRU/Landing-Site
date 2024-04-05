package com.emiren.landing.Mapper;

import com.emiren.landing.Dto.DataDTO;
import com.emiren.landing.Model.Data;

public class DataMapper {

    public static Data mapToData(DataDTO dataDTO) {
        Data data = Data.builder()
                .id(dataDTO.getId())
                .name(dataDTO.getName())
                .mail(dataDTO.getMail())
                .number(dataDTO.getNumber())
                .message(dataDTO.getMessage())
                .build();
        return data;
    }

    public static DataDTO mapToDataDto(Data data) {
        DataDTO dataDTO = DataDTO.builder()
                .id(data.getId())
                .name(data.getName())
                .mail(data.getMail())
                .number(data.getNumber())
                .message(data.getMessage())
                .build();
        return dataDTO;
    }
}
