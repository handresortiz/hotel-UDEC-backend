package co.edu.ucundinamarca.negocio.registro.service;

import co.edu.ucundinamarca.negocio.registro.model.PerfilRol;
import co.edu.ucundinamarca.negocio.registro.repository.PerfilRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerfilRolService implements IPerfilRolService{

@Autowired
private PerfilRolRepository perfilRolRepository;

    public List<PerfilRol> countAll(){ return perfilRolRepository.findAll(); }

    @Override
    public PerfilRol guardar( PerfilRol perfilRol) {
        return perfilRolRepository.save(perfilRol);
    }

    @Override
    public PerfilRol endId() {
        return perfilRolRepository.findAllById_perfil_rol();
    }
}
