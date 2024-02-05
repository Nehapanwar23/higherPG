package com.project.higherpg.repository;

import com.project.higherpg.entity.pumpEnergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface pumpEnergyRepository extends JpaRepository<pumpEnergy, UUID> {


}
