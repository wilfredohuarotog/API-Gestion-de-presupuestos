package com.ppto.sub.dto;

import java.math.BigDecimal;

public record PptoContrataDto(

        Long id,

        String descripcion,

        BigDecimal monto,

        String nombreContrata,

        Long pptoOrigenId

) {
}
