package co.edu.ucundinamarca.negocio.factura.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter

public class ventas {
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_venta;
    private Date fec_venta;
    private Long total_venta;
    private Date fec_cambio;
    //private long id_huesped;



}
