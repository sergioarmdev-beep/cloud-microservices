package com.error418.orderService.service;

import com.error418.orderService.model.Orden;

import java.util.List;

public interface OrdenService {
    List<Orden> listarOrdenes();
    Orden registrarOrden(Orden orden);
}