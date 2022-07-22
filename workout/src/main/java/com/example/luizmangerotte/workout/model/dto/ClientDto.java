package com.example.luizmangerotte.workout.model.dto;

import com.example.luizmangerotte.workout.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ClientDto {


    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate startDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean status;
    private Gender gender;
    private String email;

}
