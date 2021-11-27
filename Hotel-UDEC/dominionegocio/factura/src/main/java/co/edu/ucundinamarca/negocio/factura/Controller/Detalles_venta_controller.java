/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.Controller;

import co.edu.ucundinamarca.negocio.factura.entities.detalle_venta;
import co.edu.ucundinamarca.negocio.factura.respository.detalle_ventaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/detalles")
public class Detalles_venta_controller {
    @Autowired
    detalle_ventaRepository detalles_ventaRepository;

    @GetMapping()
    public List<detalle_venta> list(){
        return detalles_ventaRepository.findAll();
    }
    
 //    @GetMapping("/{id_cuenta}")
 //   public detalle_venta get(@PathVariable Integer id_cuenta) {
 //       detalle_venta detalle_venta = (detalle_venta) detalles_ventaRepository.findByCuenta(id_cuenta);
 //       return detalle_venta;
  //  }
}
    

