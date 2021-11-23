package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Perfil;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.PerfilesRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilesService {

    private final PerfilesRepository perfilesRepository;

    @Autowired
    public PerfilesService(PerfilesRepository perfilesRepository) {
        this.perfilesRepository = perfilesRepository;
    }

    public Perfil getPerfilById(Integer id ) {
        return perfilesRepository.findById( id ).get();
    }
}
