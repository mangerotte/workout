package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.SetExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<SetExercise, Long> {
}
