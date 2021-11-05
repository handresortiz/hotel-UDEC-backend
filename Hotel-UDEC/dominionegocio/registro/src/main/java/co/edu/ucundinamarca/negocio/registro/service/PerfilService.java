
/*
PerfilService

se inyecta el objeto con un @Autowired
y se implementa una funcion de tipo Perfil llamando a perfilRepository para traer el metodo de guardar
ya definido en IPerfilService

28/10/2021
@jhoandrojas
 */
package co.edu.ucundinamarca.negocio.registro.service;
import co.edu.ucundinamarca.negocio.registro.model.Perfil;
import co.edu.ucundinamarca.negocio.registro.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService implements IPerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public Perfil guardar(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil endId() {
        return perfilRepository.findAllOrderById_perfil();
    }


}
