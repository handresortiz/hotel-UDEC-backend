/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioProducto.controller;

import co.edu.ucundinamarca.negocio.ServicioProducto.repository.ServicioProductoRepository;
import co.edu.ucundinamarca.negocio.ServicioProducto.entities.Producto;
import io.swagger.models.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
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
@RequestMapping("/producto")
public class ServicioProductoController {
    
    @Autowired
    ServicioProductoRepository servicioproductorepository;
    
    
    
    @GetMapping("/Listar")
    public List<Producto> listar() {
        return  (List<Producto>)servicioproductorepository.findAll();
    }
    
    @GetMapping("/Editar{id}")
    public void Editar(@PathVariable Long id, Model model) {
        Optional<Producto>Producto = servicioproductorepository.findById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Producto input) {
        return null;
    }
    
    @PostMapping("/Guardar")
    public ResponseEntity<?> Agregar(@RequestBody Producto input) {
        Producto guardar = servicioproductorepository.save(input);
        return ResponseEntity.ok(guardar);
    }
    
    @DeleteMapping("/Eliminar{id}")
    public ResponseEntity<?> Borrar(@PathVariable Long id) {
        servicioproductorepository.deleteById(id);
        return null;
    }
    
}
