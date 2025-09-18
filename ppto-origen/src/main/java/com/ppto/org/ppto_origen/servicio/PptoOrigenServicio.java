package com.ppto.org.ppto_origen.servicio;

import com.ppto.org.ppto_origen.dto.PptoContrataDto;
import com.ppto.org.ppto_origen.dto.PptoOrigenDto;

import java.util.List;

public interface PptoOrigenServicio {

    List<PptoOrigenDto> findAll ();

    PptoOrigenDto findById (Long id);

    PptoOrigenDto save (PptoOrigenDto pptoContrataDto);

    PptoOrigenDto updateById (PptoOrigenDto pptoContrataDto, Long id);

    void deleteById (Long id);

    List<PptoContrataDto> findAllPptoContrataById (Long id);

}
