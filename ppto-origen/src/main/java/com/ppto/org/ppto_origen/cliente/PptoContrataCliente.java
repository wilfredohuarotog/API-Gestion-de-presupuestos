package com.ppto.org.ppto_origen.cliente;

import com.ppto.org.ppto_origen.dto.PptoContrataDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PptoContrataCliente {

    private final WebClient webClient;

    @CircuitBreaker(name = "pptoContrataClient", fallbackMethod = "fallbackContratas")
    public List<PptoContrataDto> findAllPptoContrataById (Long id){

        return webClient
                .get()
                .uri("/p-origen/{id}",id)
                .retrieve()
                .bodyToFlux(PptoContrataDto.class)
                .collectList()
                .block();
    }

    private List<PptoContrataDto> fallbackContratas(Long id, Throwable t) {
        System.out.println("Servicio ppto-contrata no disponible, usando fallback...");
        return List.of();
    }

}
