package com.ppto.org.ppto_origen.dto;

import com.ppto.org.ppto_origen.entidad.Clasificacion;

import java.math.BigDecimal;

public record PptoOrigenDto(

        Long id,

        String descripcion,

        Clasificacion clasificacion,

        BigDecimal monto

) {
}
