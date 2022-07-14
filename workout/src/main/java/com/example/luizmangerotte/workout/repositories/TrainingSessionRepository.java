package com.example.luizmangerotte.workout.repositories;
import com.example.luizmangerotte.workout.model.TrainingSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {
}
