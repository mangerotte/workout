package com.example.luizmangerotte.workout.repositories;

import com.example.luizmangerotte.workout.entities.Mesociclos;
import com.example.luizmangerotte.workout.entities.Microciclo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrocicloRepository extends JpaRepository<Microciclo, Long> {
}
