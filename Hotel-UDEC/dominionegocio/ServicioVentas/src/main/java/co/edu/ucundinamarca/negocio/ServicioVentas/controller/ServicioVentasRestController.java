/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioVentas.controller;

import co.edu.ucundinamarca.negocio.ServicioVentas.repository.ServicioVentasRepository;
import co.edu.ucundinamarca.negocio.ServicioVentas.entities.Ventas;
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
@RequestMapping("/Ventas")
public class ServicioVentasRestController {
    
    @Autowired
    ServicioVentasRepository servicioventasrepository;
    
    @GetMapping()
    public List<Ventas> listar() {
        return (List<Ventas>)servicioventasrepository.findAll();
    }
    
    @GetMapping("/Editar{id}")
    public void Editar(@PathVariable Long id) {
        Optional<Ventas> ventas = servicioventasrepository.findById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Ventas input) {
        return null;
    }
    
    @PostMapping("/Agregar")
    public ResponseEntity<?> Agregar(@RequestBody Ventas input) {
        Ventas ventas = servicioventasrepository.save(input);
        return ResponseEntity.ok(ventas);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        servicioventasrepository.deleteById(id);
        return null;
    }
    
}
