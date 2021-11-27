package co.edu.ucundinamarca.negocio.registro.service;

import co.edu.ucundinamarca.negocio.registro.model.Rol;
import org.springframework.stereotype.Service;
@Service
public interface IRolService  {
    public Rol endId();

    public Rol guardar(Rol rol);

}
