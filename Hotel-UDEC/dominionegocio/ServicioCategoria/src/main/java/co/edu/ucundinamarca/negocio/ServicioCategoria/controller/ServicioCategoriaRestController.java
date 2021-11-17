/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioCategoria.controller;

import co.edu.ucundinamarca.negocio.ServicioCategoria.entities.Categoria;
import co.edu.ucundinamarca.negocio.ServicioCategoria.repository.ServicioCategoriaRepository;
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
@RequestMapping("/categoria")
public class ServicioCategoriaRestController {
    
    @Autowired
    ServicioCategoriaRepository serviciocategoriarepository;
    
    @GetMapping("/Listar")
    public List<Categoria> Listar() {
        return (List<Categoria>)serviciocategoriarepository.findAll();
    }
    
    @GetMapping("/Editar{id}")
    public void Editar(@PathVariable Long id) {
        Optional<Categoria> Categoria = serviciocategoriarepository.findById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Categoria input) {
        return null;
    }
    
    @PostMapping("/Guardar")
    public ResponseEntity<?> Agregar(@RequestBody Categoria input) {
        Categoria guardar = serviciocategoriarepository.save(input);
        return ResponseEntity.ok(guardar);
    }
    
    @DeleteMapping("/Eliminar{id}")
    public ResponseEntity<?> Eliminar(@PathVariable Long id) {
        serviciocategoriarepository.deleteById(id);
        return null;
    }
    
}
