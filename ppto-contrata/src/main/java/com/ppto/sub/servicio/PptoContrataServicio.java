package com.ppto.sub.servicio;

import com.ppto.sub.dto.PptoContrataDto;

import java.util.List;

public interface PptoContrataServicio {

    List<PptoContrataDto> findAll ();

    PptoContrataDto findById (Long id);

    PptoContrataDto save (PptoContrataDto pptoContrataDto);

    PptoContrataDto updateById (PptoContrataDto pptoContrataDto, Long id);

    void deleteById (Long id);
}
