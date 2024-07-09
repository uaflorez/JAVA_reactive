package com.ms.auto.service;

import com.ms.auto.dto.AutoDto;
import com.ms.auto.model.AutoEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IAutoService {
    List<AutoEntity> findAll();
    Optional<AutoEntity> findById(Long id);
    AutoEntity save(AutoEntity vehiculo);
    void deleteById(Long id);
}
