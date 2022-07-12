package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Macrociclo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MacrocicloRepository extends JpaRepository<Macrociclo, Long> {
}
