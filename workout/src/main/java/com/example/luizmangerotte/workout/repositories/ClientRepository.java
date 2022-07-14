package com.example.luizmangerotte.workout.repositories;
import com.example.luizmangerotte.workout.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
