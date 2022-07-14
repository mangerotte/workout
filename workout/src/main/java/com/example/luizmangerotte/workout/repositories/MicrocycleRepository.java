package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.Microcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrocycleRepository extends JpaRepository<Microcycle, Long> {
}
