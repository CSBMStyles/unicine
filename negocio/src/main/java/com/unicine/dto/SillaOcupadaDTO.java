package com.unicine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SillaOcupadaDTO {

    private Integer codigoEntrada;

    private Integer filaEntrada;

    private Integer columnaEntrada;
}