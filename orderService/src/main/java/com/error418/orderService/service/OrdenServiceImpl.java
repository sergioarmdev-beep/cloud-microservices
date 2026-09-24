package com.error418.orderService.service;

import com.error418.orderService.dto.Producto;
import com.error418.orderService.model.Orden;
import com.error418.orderService.repository.OrdenRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {

    private final RestTemplate restTemplate;
    private final OrdenRepository ordenRepository;

    public OrdenServiceImpl(RestTemplate restTemplate, OrdenRepository ordenRepository) {
        this.restTemplate = restTemplate;
        this.ordenRepository = ordenRepository;
    }

    @Override
    public List<Orden> listarOrdenes() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden registrarOrden(Orden orden) {
        //Llamar al Microservicio producto-service
        String productoUrl = "http://localhost:8091/producto/listarProducto/" + orden.getIdproducto();
        Producto producto = restTemplate.getForObject(productoUrl, Producto.class);

        if(producto == null) throw new RuntimeException("Producto no encontrado");

        orden.setTotal(producto.getPrecio() * orden.getCantidad());
        return ordenRepository.save(orden);
    }
}
