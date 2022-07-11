package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoTreinoRepository extends JpaRepository<SessaoTreino, Long> {
}
