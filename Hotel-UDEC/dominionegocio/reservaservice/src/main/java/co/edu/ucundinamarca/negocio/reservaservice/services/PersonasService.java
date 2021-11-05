package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Personas;
import co.edu.ucundinamarca.negocio.reservaservice.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PersonasService {

    private final PersonasRepository personasRepository;

    @Autowired
    public PersonasService(PersonasRepository personasRepository) {
        this.personasRepository = personasRepository;
    }

    public Personas getPersonaById( Integer id ) {
        return personasRepository.findById( id ).get();
    }
    public Personas addPersona(Personas persona){
        String error = "";
        if(personasRepository.existsByCorreo(persona.getCorreo())){
            error= "El correo " + persona.getCorreo() + " ya existe";

        }else if(personasRepository.existsByIdentificacion(persona.getIdentificacion())){
            error ="La identificacion " + persona.getCorreo() + " ya existe";
        }
        if(!error.isEmpty()){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST,error );
        }
        return personasRepository.save(persona);
    }
    public Personas updatePersona(Integer id, Personas persona){
        return personasRepository.save(persona);
    }
    public Personas deletePersonaById( Integer id ){
        personasRepository.deleteById(id);
        return null;
    }
}
