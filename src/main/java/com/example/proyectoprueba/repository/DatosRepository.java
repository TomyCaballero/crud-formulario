package com.example.proyectoprueba.repository;

import com.example.proyectoprueba.model.Datos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosRepository extends JpaRepository<Datos, Long> {
}
