package co.edu.ucundinamarca.negocio.registro.service;

import co.edu.ucundinamarca.negocio.registro.model.Rol;
import co.edu.ucundinamarca.negocio.registro.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService implements IRolService {
    @Autowired
    RolRepository rolRepository;

    @Override
    public Rol endId() {
        return rolRepository.findAllById_rol();
    }
    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }
}
