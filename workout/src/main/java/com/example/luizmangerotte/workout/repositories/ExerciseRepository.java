package com.example.luizmangerotte.workout.repositories;
import com.example.luizmangerotte.workout.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
