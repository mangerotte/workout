package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Mesociclos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesocicloRepository extends JpaRepository<Mesociclos, Long> {
}
