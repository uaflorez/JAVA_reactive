package com.ms.auto.controller.v1;


import com.ms.auto.dto.AutoDto;
import com.ms.auto.model.AutoEntity;
import com.ms.auto.service.IAutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/auto")
public class AutoController {

    private final IAutoService iAutoService;


    @GetMapping
    public List<AutoEntity> getAllAutoEntity() {
        return iAutoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoEntity> getAutoEntityById(@PathVariable Long id) {
        return iAutoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AutoEntity createAutoEntity(@RequestBody AutoEntity autoEntity) {
        return iAutoService.save(autoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoEntity> updateAutoEntity(@PathVariable Long id, @RequestBody AutoEntity autoEntityDetails) {
        return iAutoService.findById(id)
                .map(autoEntity -> {
                    autoEntity.setMarca(autoEntityDetails.getMarca());
                    autoEntity.setModelo(autoEntityDetails.getModelo());
                    autoEntity.setTipo(autoEntityDetails.getTipo());
                    return ResponseEntity.ok(iAutoService.save(autoEntity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutoEntity(@PathVariable Long id) {
        return iAutoService.findById(id)
                .map(autoEntity -> {
                    iAutoService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
