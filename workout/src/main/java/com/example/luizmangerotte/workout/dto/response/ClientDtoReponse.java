package com.example.luizmangerotte.workout.dto.response;

import com.example.luizmangerotte.workout.model.Client;
import com.example.luizmangerotte.workout.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class ClientDtoReponse {

    private String name;
    private LocalDate startDate;
    private Gender gender;
    private String email;
    private boolean status;

    public ClientDtoReponse(Client client) {
        this.name = client.getName();
        this.startDate = client.getStartDate();
        this.gender = client.getGender();
        this.email = client.getEmail();
        this.status = client.isStatus();
    }
}
