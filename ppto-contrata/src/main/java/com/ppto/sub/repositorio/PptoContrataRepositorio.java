package com.ppto.sub.repositorio;

import com.ppto.sub.entidad.PptoContrata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PptoContrataRepositorio extends JpaRepository<PptoContrata, Long> {
}
