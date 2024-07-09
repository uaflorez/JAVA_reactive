package com.bancolombia.auto.service.impl;

import com.bancolombia.auto.dto.AutoDto;
import com.bancolombia.auto.model.AutoEntity;
import com.bancolombia.auto.repository.IAutoRepository;
import com.bancolombia.auto.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoServiceImpl implements IAutoService {

    @Autowired
    private IAutoRepository iAutoRepository;

    @Override
    public List<AutoEntity> findAll() {
        return iAutoRepository.findAll();
    }

    @Override
    public Optional<AutoEntity> findById(Long id) {
        return iAutoRepository.findById(id);
    }

    @Override
    public ResponseEntity save(AutoDto autoDto) {
        return iAutoRepository.save(autoDto);
    }

    @Override
    public void deleteById(Long id) {
        iAutoRepository.deleteById(id);
    }
}
