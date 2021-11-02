/*
PersonaService

se inyecta el objeto con un @Autowired
y se implementa una funcion de tipo Persona, llamando a PersonaRepository para traer el metodo de guardar
ya definido en IPersonnaService


aqui se implementa los metodos de PersonaRepository

28/10/2021
@jhoandrojas
 */

package co.edu.ucundinamarca.negocio.registro.service;
import co.edu.ucundinamarca.negocio.registro.model.Persona;
import co.edu.ucundinamarca.negocio.registro.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaService personaService;

    @Override
    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    public boolean existsByCorreo(String correo){
        return personaRepository.existsByCorreo(correo);
    }
    public boolean existsByIdentificacion(Long identificacion){
        return personaRepository.existsByIdentificacion(identificacion);
    }
    public boolean existsByTelefono(String telefono){
        return personaRepository.existsByTelefono( telefono);
    }

}
