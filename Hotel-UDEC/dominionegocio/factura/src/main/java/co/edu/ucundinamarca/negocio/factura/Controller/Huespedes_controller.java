
package co.edu.ucundinamarca.negocio.factura.Controller;

import co.edu.ucundinamarca.negocio.factura.entities.huespedes;
import co.edu.ucundinamarca.negocio.factura.respository.huespedesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/huespedes")
public class Huespedes_controller {
    
    @Autowired
    huespedesRepository huespedesRepository;
    @GetMapping()
    public List<huespedes> list(){
        return huespedesRepository.findAll();
    }
    @GetMapping("buscar/{id}")
    public huespedes get(@PathVariable Integer id) {
        huespedes huespedes = (huespedes) huespedesRepository.findByid(id);
        return huespedes;
    }
    
}