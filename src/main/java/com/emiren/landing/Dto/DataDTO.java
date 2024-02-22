package com.emiren.landing.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataDTO {

    private Long id;

    private String name;
    private String number;
    private String mail;
    private String message;

}
