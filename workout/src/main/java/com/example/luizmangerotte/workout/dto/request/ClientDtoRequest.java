package com.example.luizmangerotte.workout.dto.request;
import com.example.luizmangerotte.workout.model.Client;
import com.example.luizmangerotte.workout.model.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Data
@NoArgsConstructor
public class ClientDtoRequest {

    private String name;
    private LocalDate startDate;
    private Gender gender;
    private String email;
    private boolean status;

    public ClientDtoRequest(Client client) {
        this.name = client.getName();
        this.startDate = client.getStartDate();
        this.gender = client.getGender();
        this.email = client.getEmail();
        this.status = client.isStatus();
    }
}
