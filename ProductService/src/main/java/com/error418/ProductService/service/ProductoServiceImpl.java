package com.error418.ProductService.service;

import com.error418.ProductService.model.Producto;
import com.error418.ProductService.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto listarProducto(int id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto registrarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}
