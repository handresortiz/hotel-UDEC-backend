package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Personas;
import co.edu.ucundinamarca.negocio.parametricaservice.entities.Usuarios;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonasService {

    private final PersonasRepository personasRepository;

    @Autowired
    public PersonasService(PersonasRepository personasRepository) {
        this.personasRepository = personasRepository;
    }

    public List<Personas> findAllPersonas() { return personasRepository.findAll();}

    public Personas getPersonaById( Integer id ) {
        return personasRepository.findById( id ).get();
    }

    public boolean existsPersona( Personas persona ){
        String error = "";
        if(persona.getCorreo() != null
                && personasRepository.existsByCorreo( persona.getCorreo() )){
            error= "El correo " + persona.getCorreo() + " ya existe";

        }

        if(persona.getIdentificacion() != null
                && personasRepository.existsByIdentificacion( persona.getIdentificacion() )){
            error ="La identificacion " + persona.getIdentificacion() + " ya existe";
        }

        if(!error.isEmpty()){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, error );
        }

        return false;
    }

    public Personas addPersona(Personas persona){
        existsPersona( persona );
        return personasRepository.save(persona);
    }

    @Transactional
    public Personas updatePersona(Integer id, Personas persona){
        Personas personaUp = personasRepository.findById(id).get();
        if(persona.getPri_nombre() != null){
            personaUp.setPri_nombre(persona.getPri_nombre());
        }
        if(persona.getSeg_nombre() != null){
            personaUp.setSeg_nombre(persona.getSeg_nombre());
        }
        if(persona.getPri_apellido() != null){
            personaUp.setPri_apellido(persona.getPri_apellido());
        }
        if(persona.getSeg_apellido() != null){
            personaUp.setSeg_apellido(persona.getSeg_apellido());
        }
        if(persona.getRazon_social() != null){
            personaUp.setRazon_social(persona.getRazon_social());
        }
        if(persona.getDireccion() != null){
            personaUp.setDireccion(persona.getDireccion());
        }
        if(persona.getTelefono() != null){
            personaUp.setTelefono(persona.getTelefono());
        }
        if(persona.getCorreo() != null){
            personaUp.setCorreo(persona.getCorreo());
        }
        if(persona.getIdentificacion() != null){
            personaUp.setIdentificacion(persona.getIdentificacion());
        }
        if(persona.getGenero() != null){
            personaUp.setGenero(persona.getGenero());
        }
        //return personasRepository.save(persona);
        return personaUp;
    }

    public Personas deletePersonaById( Integer id ){
        personasRepository.deleteById(id);
        return null;
    }
}
