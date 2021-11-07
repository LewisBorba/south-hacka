package com.south.health.domain.medic.repository;

import com.south.health.domain.medic.model.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Medic, Integer> {
    Medic findByUserId(Integer userId);


}
