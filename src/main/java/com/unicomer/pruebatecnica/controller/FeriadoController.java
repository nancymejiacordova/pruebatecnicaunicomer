/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicomer.pruebatecnica.controller;

import com.unicomer.pruebatecnica.entity.Feriado;
import com.unicomer.pruebatecnica.service.HolidayService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author nancy
 */
@RestController
@RequestMapping("/feriados")
public class FeriadoController {
    
    private final HolidayService holidayService;

    public FeriadoController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

   @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Mono<Feriado[]> getFeriados(
            @RequestParam String tipo,
            @RequestParam String desde,
            @RequestParam String hasta) {
        
        return holidayService.getFeriados(tipo, desde, hasta);
    }

    
}
