package com.ppto.org.ppto_origen.controlador;

import com.ppto.org.ppto_origen.dto.PptoContrataDto;
import com.ppto.org.ppto_origen.dto.PptoOrigenDto;
import com.ppto.org.ppto_origen.servicio.PptoOrigenServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/p-origen")
public class PptoOrigenControlador {

    private final PptoOrigenServicio pptoOrigenServicio;

    @GetMapping
    public ResponseEntity<List<PptoOrigenDto>> findAll() {
        return ResponseEntity.ok(pptoOrigenServicio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PptoOrigenDto> findById(@PathVariable Long id) {
        PptoOrigenDto dto = pptoOrigenServicio.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PptoOrigenDto> save(@RequestBody PptoOrigenDto dto) {
        PptoOrigenDto saved = pptoOrigenServicio.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PptoOrigenDto> update(@PathVariable Long id, @RequestBody PptoOrigenDto dto) {
        PptoOrigenDto updated = pptoOrigenServicio.updateById(dto, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pptoOrigenServicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/p-contrata/{id}")
    public ResponseEntity<List<PptoContrataDto>> findAllPptoContrataById (@PathVariable Long id){
        return ResponseEntity.ok(pptoOrigenServicio.findAllPptoContrataById(id));
    }
}
