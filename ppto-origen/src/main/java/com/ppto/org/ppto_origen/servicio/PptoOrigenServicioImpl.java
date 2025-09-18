package com.ppto.org.ppto_origen.servicio;

import com.ppto.org.ppto_origen.dto.PptoOrigenDto;
import com.ppto.org.ppto_origen.entidad.PptoOrigen;
import com.ppto.org.ppto_origen.mapper.PptoOrigenMapper;
import com.ppto.org.ppto_origen.repositorio.PptoOrigenRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PptoOrigenServicioImpl implements PptoOrigenServicio{

    private final PptoOrigenRepositorio pptoOrigenRepositorio;
    private final PptoOrigenMapper pptoOrigenMapper;

    @Override
    public List<PptoOrigenDto> findAll() {
        return pptoOrigenRepositorio.findAll().stream()
                .map(pptoOrigenMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PptoOrigenDto findById(Long id) {
        PptoOrigen pptoOrigen = existsById(id);
        return pptoOrigenMapper.toDto(pptoOrigen);
    }

    @Override
    public PptoOrigenDto save(PptoOrigenDto pptoOrigenDto) {
        PptoOrigen pptoOrigen = pptoOrigenMapper.toEntity(pptoOrigenDto);
        return pptoOrigenMapper.toDto(pptoOrigenRepositorio.save(pptoOrigen));
    }

    @Override
    public PptoOrigenDto updateById(PptoOrigenDto pptoOrigenDto, Long id) {
        PptoOrigen pptoOrigen = existsById(id);
        pptoOrigenMapper.updateEntityFromDto(pptoOrigenDto,pptoOrigen);
        pptoOrigenRepositorio.save(pptoOrigen);
        return pptoOrigenMapper.toDto(pptoOrigen);
    }

    @Override
    public void deleteById(Long id) {
        PptoOrigen pptoOrigen = existsById(id);
        pptoOrigenRepositorio.delete(pptoOrigen);
    }

    private PptoOrigen existsById(Long id){
        return pptoOrigenRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("No existe el ppto con el ID: "+ id));
    }

}
