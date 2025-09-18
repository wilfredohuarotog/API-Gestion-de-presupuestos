package com.ppto.sub.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "ppto_contrata")
public class PptoContrata {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(precision = 7, scale = 2, nullable = false)
    private BigDecimal monto;

    @Column( name = "contrata", nullable = false)
    private String nombreContrata;

    @Column(name = "ppto_origen_id")
    private Long pptoOrigenId;


}
