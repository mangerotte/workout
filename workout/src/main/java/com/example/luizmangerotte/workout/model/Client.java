package com.example.luizmangerotte.workout.model;
import com.example.luizmangerotte.workout.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Client extends RepresentationModel<Client> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate startDate;

    private boolean status;

    private Gender gender;

    private String email;
    private String password;


    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<PhysicalExamination> physicalExaminationList = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Macrocycle> macrocyclesList = new ArrayList<>();

    public Client(Long id, String name, LocalDate startDate, boolean status, Gender gender, String email, String password) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.status = status;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

}
