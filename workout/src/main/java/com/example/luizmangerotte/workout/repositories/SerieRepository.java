package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.Serie;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
