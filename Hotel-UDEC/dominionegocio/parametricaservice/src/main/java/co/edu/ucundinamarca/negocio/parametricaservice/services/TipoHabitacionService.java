package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.TipoHabitacion;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class TipoHabitacionService {

    private final TipoHabitacionRepository tipoHabitacionRepository;
    private final GaleriaHabitacionService galeriaService;

    @Autowired
    public TipoHabitacionService(TipoHabitacionRepository tipoHabitacionRepository, GaleriaHabitacionService galeriaService) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
        this.galeriaService = galeriaService;
    }

    public TipoHabitacion createTipoHabitacion( TipoHabitacion tipo ) {
        return this.tipoHabitacionRepository.save( tipo );
    }

    public TipoHabitacion findById( Integer id ){
        return tipoHabitacionRepository.findById( id ).get();
    }

    @Transactional
    public TipoHabitacion actualizarTipo( Integer id, TipoHabitacion t ){
        TipoHabitacion tipo = tipoHabitacionRepository.findById( id )
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.BAD_REQUEST, "Tipo de habitacion con id " + id +" no encontrado. "));

        if(t.getNom_tipo_habitacion() != null){
            tipo.setNom_tipo_habitacion( t.getNom_tipo_habitacion() );
        }

        if(t.getDesc_tipo_habitacion() != null){
            tipo.setDesc_tipo_habitacion( t.getDesc_tipo_habitacion() );
        }

        if(t.getPrecio_habitacion() != null){
            tipo.setPrecio_habitacion( t.getPrecio_habitacion() );
        }

        if(t.getNum_adultos() != null){
            tipo.setNum_adultos( t.getNum_adultos() );
        }

        if(t.getNum_ninos() != null){
            tipo.setNum_ninos( t.getNum_ninos() );
        }

        return tipo;
    }

    public TipoHabitacion eliminarTipoHabitacion(Integer id){

        TipoHabitacion tipo = tipoHabitacionRepository.findById( id )
                                .orElseThrow(() -> new ResponseStatusException( HttpStatus.BAD_REQUEST, "Tipo de habitacion con id " + id +" no encontrado. "));


        //Eliminar la galeria
        galeriaService.eliminarGaleria( id );

        //Eliminar el registro de tipo de habitacion
        tipoHabitacionRepository.deleteById( id );

        return tipo;
    }
}
