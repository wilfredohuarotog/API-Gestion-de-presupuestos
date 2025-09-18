package com.ppto.org.ppto_origen.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "ppto_origen")
public class PptoOrigen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Clasificacion clasificacion;

    @Column(precision = 7, scale = 2, nullable = false)
    private BigDecimal monto;
}
