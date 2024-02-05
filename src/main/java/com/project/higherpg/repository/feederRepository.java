package com.project.higherpg.repository;

import com.project.higherpg.entity.feeder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface feederRepository extends JpaRepository<feeder, UUID> {

}
