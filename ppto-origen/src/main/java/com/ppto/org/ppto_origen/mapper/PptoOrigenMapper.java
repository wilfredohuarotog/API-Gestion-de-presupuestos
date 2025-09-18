package com.ppto.org.ppto_origen.mapper;

import com.ppto.org.ppto_origen.dto.PptoOrigenDto;
import com.ppto.org.ppto_origen.entidad.PptoOrigen;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PptoOrigenMapper {

    PptoOrigenDto toDto (PptoOrigen pptoOrigen);

    @Mapping(target = "id", ignore = true)
    PptoOrigen toEntity (PptoOrigenDto pptoOrigenDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto (PptoOrigenDto pptoOrigenDto, @MappingTarget PptoOrigen pptoOrigen);
}
