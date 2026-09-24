package com.error418.orderService.controller;

import com.error418.orderService.model.Orden;
import com.error418.orderService.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orden")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping("/listarOrdenes")
    public ResponseEntity<List<Orden>> listarOrdenes() {
        return new ResponseEntity<List<Orden>>(ordenService.listarOrdenes(), HttpStatus.OK);
    }

    @PostMapping("/registrarOrden")
    public ResponseEntity<Orden> registrarOrden(@RequestBody Orden orden) {
        return new ResponseEntity<Orden>(ordenService.registrarOrden(orden), HttpStatus.CREATED);
    }
}

