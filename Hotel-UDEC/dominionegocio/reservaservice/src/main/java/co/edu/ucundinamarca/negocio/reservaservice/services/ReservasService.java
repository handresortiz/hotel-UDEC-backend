package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Huespedes;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HuespedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservasService {

    private final HuespedesRepository huespedesRepository;

    @Autowired
    public ReservasService(HuespedesRepository huespedesRepository) {
        this.huespedesRepository = huespedesRepository;
    }

    public Huespedes getHuespedById( Integer id ) {
        return huespedesRepository.findById( id ).get();
    }

}
