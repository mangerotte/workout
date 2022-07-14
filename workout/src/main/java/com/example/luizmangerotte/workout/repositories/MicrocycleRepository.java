package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.model.Microcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrocycleRepository extends JpaRepository<Microcycle, Long> {
}
