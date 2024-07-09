package com.ms.auto.service.impl;

import com.ms.auto.model.AutoEntity;
import com.ms.auto.repository.IAutoRepository;
import com.ms.auto.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoServiceImpl implements IAutoService {

    @Autowired
    private IAutoRepository vehiculoRepository;

    @Override
    public List<AutoEntity> findAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Optional<AutoEntity> findById(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public AutoEntity save(AutoEntity vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public void deleteById(Long id) {
        vehiculoRepository.deleteById(id);
    }
}