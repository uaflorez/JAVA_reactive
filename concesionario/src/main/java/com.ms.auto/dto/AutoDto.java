package com.ms.auto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutoDto {
    @NotBlank
    @NotEmpty
    @Size(min = 5 ,max = 12 ,message = "el tamaño minimo es 5 y el maximo 12")
    private String marca;

    @NotBlank
    @NotEmpty
    private  String tipo;
    @NotBlank
    //@Modelo
    private  String modelo;


}
