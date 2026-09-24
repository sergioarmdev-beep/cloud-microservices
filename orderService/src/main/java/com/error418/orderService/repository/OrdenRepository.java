package com.error418.orderService.repository;

import com.error418.orderService.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}
