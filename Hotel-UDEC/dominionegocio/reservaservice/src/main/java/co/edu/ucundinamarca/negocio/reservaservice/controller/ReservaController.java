package co.edu.ucundinamarca.negocio.reservaservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reserva")
public class ReservaController {

    @GetMapping
    public String hello(){
        return "Hola mundo!";
    }
}
