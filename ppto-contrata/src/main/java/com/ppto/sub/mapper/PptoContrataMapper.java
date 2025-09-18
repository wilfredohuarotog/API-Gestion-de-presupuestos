package com.ppto.sub.mapper;

import com.ppto.sub.dto.PptoContrataDto;
import com.ppto.sub.entidad.PptoContrata;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PptoContrataMapper {

    PptoContrataDto toDto (PptoContrata pptoContrata);

    @Mapping(target = "id", ignore = true)
    PptoContrata toEntity (PptoContrataDto pptoContrataDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto (PptoContrataDto pptoContrataDto, @MappingTarget PptoContrata pptoContrata);

}
