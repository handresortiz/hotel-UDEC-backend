package co.edu.ucundinamarca.negocio.facturaservice.Controller;

import co.edu.ucundinamarca.negocio.facturaservice.entities.ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class Ventas_controller {

    @Autowired
    co.edu.ucundinamarca.negocio.facturaservice.respository.ventasRepository ventasRepository;

    @GetMapping()
    public List<ventas> list(){
        return ventasRepository.findAll();
    }

}
