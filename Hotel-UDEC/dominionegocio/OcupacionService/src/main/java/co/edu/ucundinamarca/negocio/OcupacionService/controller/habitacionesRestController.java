/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.OcupacionService.controller;

import co.edu.ucundinamarca.negocio.OcupacionService.entities.habitaciones;
import co.edu.ucundinamarca.negocio.OcupacionService.repository.habitacionesRepository;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.tcp.TcpClient;

/**
 *
 * @author Carlos Ducuara
 */

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/ocupacion")
public class habitacionesRestController {
    
    @Autowired
    habitacionesRepository  habitacionesRepository;
          
    
    @GetMapping("list")
    public List<habitaciones> list() {
        return habitacionesRepository.findAll();
    }
    
    
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }
    
    
    @PutMapping("/{id}")
    public habitaciones put(@PathVariable Integer id, @RequestBody habitaciones h) {
        habitacionesRepository.save(h);
        return h;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
