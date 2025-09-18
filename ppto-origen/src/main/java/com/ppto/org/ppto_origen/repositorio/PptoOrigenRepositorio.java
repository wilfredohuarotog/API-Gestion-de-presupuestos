package com.ppto.org.ppto_origen.repositorio;

import com.ppto.org.ppto_origen.entidad.PptoOrigen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PptoOrigenRepositorio extends JpaRepository<PptoOrigen,Long> {
}
