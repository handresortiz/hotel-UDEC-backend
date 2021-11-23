package co.edu.ucundinamarca.negocio.chartsservice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_venta;

    private Date fec_venta;

    private Long total_venta;

    private Date fec_cambio;

    private Integer id_usuario_cambio;
}
