package com.ms.auto.repository;

import com.ms.auto.model.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAutoRepository extends JpaRepository<AutoEntity,Long> {
    //JPA Query Methods

    Optional<AutoEntity> findByModelAndTipo(String model , String tipo);

    Optional<AutoEntity> findByModel(String email);
}
