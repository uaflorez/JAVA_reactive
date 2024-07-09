package com.bancolombia.auto.controller.v2.doc;

import com.bancolombia.auto.dto.AutoDto;
import com.bancolombia.auto.model.AutoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "auto" , description = "API expuesta para la adminsitracion de usuario")
@RequestMapping("/api/v2/auto")
public interface IAutoDocV2 {
    @Operation(summary = "create auto")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "auto created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "endpoint not founded",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    @PostMapping
    ResponseEntity<AutoEntity> create(@RequestBody @Valid AutoDto autoDto);
}


