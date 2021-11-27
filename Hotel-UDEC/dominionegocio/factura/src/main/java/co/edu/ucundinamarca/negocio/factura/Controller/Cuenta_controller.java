/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.Controller;

import co.edu.ucundinamarca.negocio.factura.entities.cuenta;
import co.edu.ucundinamarca.negocio.factura.respository.cuentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/cuenta")
public class Cuenta_controller {
    @Autowired
    cuentaRepository cuentaRepository;

    
    
    @GetMapping()
    public List<cuenta> list(){
        return cuentaRepository.findAll();
    }
        @GetMapping("/{id}")
        public cuenta get(@PathVariable Integer id) {
        cuenta cuenta = (cuenta) cuentaRepository.findByid(id);
        return cuenta;
    }
}
