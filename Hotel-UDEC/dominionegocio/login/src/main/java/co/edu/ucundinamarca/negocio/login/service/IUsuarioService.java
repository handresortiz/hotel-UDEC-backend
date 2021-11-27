package co.edu.ucundinamarca.negocio.login.service;

import co.edu.ucundinamarca.negocio.login.model.Usuario;

public interface IUsuarioService {

public Usuario login(String login, String clave);
}
