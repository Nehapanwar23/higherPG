package com.project.higherpg.repository;

import java.util.Optional;
import java.util.UUID;

import com.project.higherpg.entity.receivingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface receivingRepository extends JpaRepository<receivingStation, UUID> {
    Optional<receivingStation> findById(UUID RSId);
}

