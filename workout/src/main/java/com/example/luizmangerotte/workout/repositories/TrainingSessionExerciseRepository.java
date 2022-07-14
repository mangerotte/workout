package com.example.luizmangerotte.workout.repositories;
import com.example.luizmangerotte.workout.entities.TrainingSessionExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingSessionExerciseRepository extends JpaRepository<TrainingSessionExercise, Long> {
}
