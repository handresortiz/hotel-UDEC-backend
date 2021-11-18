/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioDetalleVentas.controller;

import co.edu.ucundinamarca.negocio.ServicioDetalleVentas.entities.DetalleVentas;
import co.edu.ucundinamarca.negocio.ServicioDetalleVentas.repository.ServicioDetalleVentasRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/DetalleVentas")
public class ServicioDetalleVentasRestController {
    
    @Autowired
    ServicioDetalleVentasRepository serviciodetalleventasrepository;
    
    @GetMapping("/Listar")
    public List<DetalleVentas> Listar() {
        return (List<DetalleVentas>)serviciodetalleventasrepository.findAll();
    }
    
    @GetMapping("/Editar{id}")
    public void Editar(@PathVariable Long id) {
        Optional<DetalleVentas> detalleventas = serviciodetalleventasrepository.findById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody DetalleVentas input) {
        return null;
    }
    
    @PostMapping("/Agregar")
    public ResponseEntity<?> Agregar(@RequestBody DetalleVentas input) {
        DetalleVentas guardar = serviciodetalleventasrepository.save(input);
        return ResponseEntity.ok(guardar);
    }
    
    @DeleteMapping("/Eliminar{id}")
    public ResponseEntity<?> Eliminar(@PathVariable Long id) {
        serviciodetalleventasrepository.deleteById(id);
        return null;
    }
    
}
