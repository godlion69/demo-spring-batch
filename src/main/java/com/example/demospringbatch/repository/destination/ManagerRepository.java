package com.example.demospringbatch.repository.destination;

import com.example.demospringbatch.domain.destination.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
