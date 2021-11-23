package co.edu.ucundinamarca.negocio.chartsservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "reservaciones" )
public class Reservacion {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_reservacion;

    @NotNull
    private Long valor;

    @NotNull
    private Date fec_inicio;

    @NotNull
    private Date fec_fin;

    private Date fec_cambio;

    private Long id_usuario_cambio;

    @NotNull
    private Integer habitacion;

    @NotNull
    private Integer cuenta;
}
