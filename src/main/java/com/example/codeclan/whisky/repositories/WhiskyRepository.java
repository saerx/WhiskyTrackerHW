package com.example.codeclan.whisky.repositories;

import com.example.codeclan.whisky.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findByYear(int year);
    List<Whisky> findByDistilleryIdAndAge(Long distillery_id, int age);
    List<Whisky> findByDistilleryRegion(String region);
}
