package com.ppto.org.ppto_origen.dto;

import java.math.BigDecimal;

public record PptoContrataDto(

        Long id,

        String descripcion,

        BigDecimal monto,

        String nombreContrata,

        Long pptoOrigenId

) {
}
