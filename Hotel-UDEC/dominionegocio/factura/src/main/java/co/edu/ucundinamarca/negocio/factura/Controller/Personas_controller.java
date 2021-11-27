/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.Controller;

import co.edu.ucundinamarca.negocio.factura.entities.personas;
import co.edu.ucundinamarca.negocio.factura.respository.personasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin( value = "http://localhost:4200")
@RestController
@RequestMapping("/personas")

public class Personas_controller {
    
    @Autowired
    personasRepository personasRepository;

    @GetMapping()
    public List<personas> list(){
        return personasRepository.findAll();
    }
 
    
    
     @GetMapping("buscar/{identificacion}")
    public personas get(@PathVariable Integer identificacion) {
        personas personas = (personas) personasRepository.findByIdentificacion(identificacion);
        return personas;
    }
    
}
