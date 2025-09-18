package com.ppto.sub.controlador;

import com.ppto.sub.dto.PptoContrataDto;
import com.ppto.sub.servicio.PptoContrataServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/p-contrata")
public class PptoContrataControlador {

    private final PptoContrataServicio pptoContrataServicio;

    @GetMapping
    public ResponseEntity<List<PptoContrataDto>> findAll() {
        return ResponseEntity.ok(pptoContrataServicio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PptoContrataDto> findById(@PathVariable Long id) {
        PptoContrataDto dto = pptoContrataServicio.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PptoContrataDto> save(@RequestBody PptoContrataDto dto) {
        PptoContrataDto saved = pptoContrataServicio.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PptoContrataDto> update(@PathVariable Long id, @RequestBody PptoContrataDto dto) {
        PptoContrataDto updated = pptoContrataServicio.updateById(dto, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pptoContrataServicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/p-origen/{id}")
    public ResponseEntity<List<PptoContrataDto>> findByPptoOrigenId (@PathVariable Long id){
        return ResponseEntity.ok(pptoContrataServicio.findByPptoOrigenId(id));
    }

}
