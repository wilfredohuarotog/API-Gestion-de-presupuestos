package com.ppto.sub.servicio;

import com.ppto.sub.dto.PptoContrataDto;
import com.ppto.sub.entidad.PptoContrata;
import com.ppto.sub.excepciones.ResourceNotFoundException;
import com.ppto.sub.mapper.PptoContrataMapper;
import com.ppto.sub.repositorio.PptoContrataRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PptoContrataServicioImpl implements PptoContrataServicio {

    private final PptoContrataRepositorio pptoContrataRepositorio;
    private final PptoContrataMapper pptoContrataMapper;

    @Override
    public List<PptoContrataDto> findAll() {
        return pptoContrataRepositorio.findAll().stream()
                .map(pptoContrataMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PptoContrataDto findById(Long id) {
        PptoContrata pptoContrata = existsById(id);
        return pptoContrataMapper.toDto(pptoContrata);
    }

    @Override
    public PptoContrataDto save(PptoContrataDto pptoContrataDto) {
        PptoContrata pptoContrata = pptoContrataMapper.toEntity(pptoContrataDto);
        return pptoContrataMapper.toDto(pptoContrataRepositorio.save(pptoContrata));
    }

    @Override
    public PptoContrataDto updateById(PptoContrataDto pptoContrataDto, Long id) {
        PptoContrata pptoContrata = existsById(id);
        pptoContrataMapper.updateEntityFromDto(pptoContrataDto,pptoContrata);
        pptoContrataRepositorio.save(pptoContrata);
        return pptoContrataMapper.toDto(pptoContrata);
    }

    @Override
    public void deleteById(Long id) {
        PptoContrata pptoContrata = existsById(id);
        pptoContrataRepositorio.delete(pptoContrata);
    }

    @Override
    public List<PptoContrataDto> findByPptoOrigenId(Long id) {

        List<PptoContrata> pptoContratas = pptoContrataRepositorio.findByPptoOrigenId(id);

        return pptoContratas.stream()
                .map(pptoContrataMapper::toDto)
                .collect(Collectors.toList());
    }

    private PptoContrata existsById(Long id){
        return pptoContrataRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe el ppto con el ID: "+ id));
    }
}
