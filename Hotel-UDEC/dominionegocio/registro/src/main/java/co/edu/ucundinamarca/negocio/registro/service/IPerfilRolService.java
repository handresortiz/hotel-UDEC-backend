package co.edu.ucundinamarca.negocio.registro.service;

import co.edu.ucundinamarca.negocio.registro.model.Perfil;
import co.edu.ucundinamarca.negocio.registro.model.PerfilRol;
import co.edu.ucundinamarca.negocio.registro.model.Usuario;

public interface IPerfilRolService {
    public PerfilRol guardar(PerfilRol perfilRol);
    public PerfilRol endId();
}
