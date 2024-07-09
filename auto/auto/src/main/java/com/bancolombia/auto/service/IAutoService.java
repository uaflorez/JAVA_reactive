package com.bancolombia.auto.service;

import com.bancolombia.auto.dto.AutoDto;
import com.bancolombia.auto.model.AutoEntity;

import java.util.List;
import java.util.Optional;

public interface IAutoService {
    List<AutoEntity> findAll();
    Optional<AutoEntity> findById(Long id);
    AutoEntity save(AutoDto vehiculo);
    void deleteById(Long id);
}
