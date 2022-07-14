package com.example.luizmangerotte.workout.repositories;
import com.example.luizmangerotte.workout.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
