package co.edu.ucundinamarca.negocio.reservaservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ReservaForm {
    @NotNull
    private Personas cliente;

    @NotNull
    private Integer[] id_habitaciones;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull
    private Date fec_inicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull
    private Date fec_fin;

}
