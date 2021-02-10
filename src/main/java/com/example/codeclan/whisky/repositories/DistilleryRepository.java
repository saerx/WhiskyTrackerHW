package com.example.codeclan.whisky.repositories;

import com.example.codeclan.whisky.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
        List<Distillery> findByRegion(String region);
        List<Distillery> findByWhiskiesYear(int year);

}
