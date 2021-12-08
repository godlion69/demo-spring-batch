package com.example.demospringbatch.repository.source;

import com.example.demospringbatch.domain.source.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
