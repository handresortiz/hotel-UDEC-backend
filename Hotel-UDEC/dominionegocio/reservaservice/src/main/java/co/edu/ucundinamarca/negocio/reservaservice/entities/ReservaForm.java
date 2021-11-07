package co.edu.ucundinamarca.negocio.reservaservice.entities;

import co.edu.ucundinamarca.negocio.reservaservice.validators.MinDateToday;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ReservaForm {
    @NotNull( message = "Datos del cliente requeridos")
    @Valid
    private Personas cliente;

    @NotNull( message = "Arreglo con los id de las habitaciones requerido" )
    @NotEmpty( message = "El arreglo de los id de habitaciones debe contener al menos un id" )
    private Integer[] id_habitaciones;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull( message = "Fecha inicio requerida" )
    @MinDateToday( message = "Fecha inicio debe ser mayor o igual a hoy" )
    private Date fec_inicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull( message = "Fecha fin requerida" )
    @MinDateToday( message = "Fecha fin debe ser mayor o igual a hoy" )
    private Date fec_fin;

}
