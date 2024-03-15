package com.example.proyectoprueba.controller;

import com.example.proyectoprueba.model.Datos;
import com.example.proyectoprueba.repository.DatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/datos")
public class datosController {

    @Autowired
    private DatosRepository datosRepository;

    @GetMapping
    public List<Datos> getAllPersonas() {
        return datosRepository.findAll();
    }

    @GetMapping("/{id}")
    public Datos getPersonaById(@PathVariable Long id) {
        Optional<Datos> optionalPersona = datosRepository.findById(id);
        return optionalPersona.orElse(null);
    }

    @PostMapping
    public Datos createPersona(@RequestBody Datos persona) {
        return datosRepository.save(persona);
    }

    @PutMapping("/{id}")
    public Datos updatePersona(@PathVariable Long id, @RequestBody Datos personaDetails) {
        Optional<Datos> optionalPersona = datosRepository.findById(id);
        if (optionalPersona.isPresent()) {
            Datos persona = optionalPersona.get();
            persona.setNombre(personaDetails.getNombre());
            persona.setGenero(personaDetails.getGenero());
            persona.setDireccion(personaDetails.getDireccion());
            persona.setPais(personaDetails.getPais());
            persona.setEstado(personaDetails.getEstado());
            return datosRepository.save(persona);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        datosRepository.deleteById(id);
    }
}


