package co.edu.ucundinamarca.negocio.chartsservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_habitacion;

    @NotNull
    private Integer id_tipo_habitacion;

    private Long num_habitacion;

    private Date fec_cambio;

    private Long id_usuario_cambio;

    private Boolean limpieza;

    private Character estado;

    private Boolean mantenimiento;

}
