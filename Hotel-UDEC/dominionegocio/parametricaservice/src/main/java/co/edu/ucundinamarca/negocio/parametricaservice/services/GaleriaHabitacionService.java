package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.GaleriaHabitacion;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.GaleriaHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GaleriaHabitacionService {

    private final GaleriaHabitacionRepository galeriaRepository;

    @Autowired
    public GaleriaHabitacionService(GaleriaHabitacionRepository galeriaRepository) {
        this.galeriaRepository = galeriaRepository;
    }

    public List<GaleriaHabitacion> guardarGaleria(List<String> urls, Integer id_tipo_habitacion ){
        List<GaleriaHabitacion> galeria = new ArrayList<>();
        GaleriaHabitacion imagen;
        for(String url: urls){
            imagen = new GaleriaHabitacion();
            imagen.setId_tipo_habitacion( id_tipo_habitacion );
            imagen.setUrl_imagen( url );
            galeria.add( imagen );
        }

        return galeriaRepository.saveAll( galeria );
    }
}
