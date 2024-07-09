package com.bancolombia.auto.service;

import com.bancolombia.auto.dto.AutoDto;
import com.bancolombia.auto.model.AutoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IAutoService {
    List<AutoEntity> findAll();
    Optional<AutoEntity> findById(Long id);
    ResponseEntity save(AutoDto autoDto);
    void deleteById(Long id);
}
