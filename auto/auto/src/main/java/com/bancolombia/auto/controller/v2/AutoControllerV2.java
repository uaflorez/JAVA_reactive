package com.bancolombia.auto.controller.v2;


import com.bancolombia.auto.controller.v2.doc.IAutoDocV2;
import com.bancolombia.auto.dto.AutoDto;
import com.bancolombia.auto.model.AutoEntity;
import com.bancolombia.auto.service.IAutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AutoControllerV2 implements IAutoDocV2 {

    private final IAutoService iAutoService;
    @Override
    public ResponseEntity<AutoEntity> create(AutoDto autoDto){
        return this.iAutoService.save(autoDto);

    }
}
