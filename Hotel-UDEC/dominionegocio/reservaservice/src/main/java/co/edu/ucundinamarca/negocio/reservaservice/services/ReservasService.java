package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Huespedes;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HuespedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservasService {

    private final HuespedesRepository huespedesRepository;

    @Autowired
    public ReservasService(HuespedesRepository huespedesRepository, PersonasService personasService) {
        this.huespedesRepository = huespedesRepository;
    }

    public Huespedes getHuespedById( Integer id ) {
        return huespedesRepository.findById( id ).get();
    }
    public Huespedes addHuespedPar(Huespedes huesped){
        return huespedesRepository.save(huesped);
    }
    public Huespedes addHuesped(Huespedes huesped){

        return huespedesRepository.save(huesped);
    }
    public Huespedes updateHuesped(Integer id, Huespedes huesped){
        return huespedesRepository.save(huesped);
    }
    public Huespedes deleteHuespedById( Integer id ){
        huespedesRepository.deleteById(id);
        return null;
    }
}
