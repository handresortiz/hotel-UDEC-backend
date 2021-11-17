package co.edu.ucundinamarca.negocio.factura.Controller;

import co.edu.ucundinamarca.negocio.factura.entities.ventas;
import co.edu.ucundinamarca.negocio.factura.respository.ventasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class Ventas_controller {

    @Autowired
    ventasRepository ventasRepository;

    @GetMapping()
    public List<ventas> list(){
        return ventasRepository.findAll();
    }

}
