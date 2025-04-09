/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicomer.pruebatecnica.service;

import com.unicomer.pruebatecnica.entity.Feriado;
import java.lang.System.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author nancy
 */
@Service
public class HolidayService {
        private final WebClient webClient;
//        private static final Logger logger = (Logger) LoggerFactory.getLogger(HolidayService.class);
    
    @Value("${api.url}")
    private String apiUrl;

    public HolidayService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(apiUrl).build();
    }

    public Mono<Feriado[]> getFeriados(String tipo, String desde, String hasta) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("tipo", tipo)
                        .queryParam("desde", desde)
                        .queryParam("hasta", hasta)
                        .build())
                .retrieve()
                .bodyToMono(Feriado[].class);
    }

}
