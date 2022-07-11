package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.ExercicioSessaoTreino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioSessaoTreinoRepository extends JpaRepository<ExercicioSessaoTreino, Long> {
}
