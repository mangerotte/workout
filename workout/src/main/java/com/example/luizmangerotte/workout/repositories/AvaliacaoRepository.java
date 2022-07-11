package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
