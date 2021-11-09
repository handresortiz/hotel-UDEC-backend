/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioProducto.controller;

import co.edu.ucundinamarca.negocio.ServicioProducto.repository.ServicioProductoRepository;
import co.edu.ucundinamarca.negocio.ServicioProducto.entities.Producto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
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
    
    
    
    @GetMapping()
    public List<Producto> list() {
        return  servicioproductorepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Producto get(@PathVariable String id) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Producto input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Producto input) {
        Producto guardar = servicioproductorepository.save(input);
        return ResponseEntity.ok(guardar);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
