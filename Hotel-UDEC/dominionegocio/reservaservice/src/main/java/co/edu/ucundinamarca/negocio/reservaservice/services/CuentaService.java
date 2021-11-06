package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Cuenta;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Reservaciones;
import co.edu.ucundinamarca.negocio.reservaservice.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    @Autowired
    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public Cuenta findById( Integer id_cuenta ){
        return cuentaRepository.findById( id_cuenta ).get();
    }

    public Cuenta registrarCuenta( Integer id_huesped, List<Reservaciones> reservas ) {
        Cuenta cuenta = new Cuenta();
        Long total = calcularTotal( reservas );

        cuenta.setId_huesped( id_huesped );
        cuenta.setTotal(total);
        cuenta.setFec_creada();
        cuenta.setFec_cambio();

        return cuentaRepository.save( cuenta );
    }

    private Long calcularTotal(List<Reservaciones> reservas){
        return reservas.stream().reduce(0L, (acum, reserva) -> acum + reserva.getValor(), Long::sum);
    }


}
