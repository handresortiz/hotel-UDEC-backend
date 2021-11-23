package co.edu.ucundinamarca.negocio.chartsservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_cuenta;

    private Long total;

    private Date fec_creada;

    @NotNull
    private Integer id_huesped;

    private Date fec_cambio;

    private Integer id_usuario_cambio;
}
