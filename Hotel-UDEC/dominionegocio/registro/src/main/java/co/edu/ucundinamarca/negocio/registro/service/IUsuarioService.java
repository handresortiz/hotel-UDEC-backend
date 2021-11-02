/*
IUsuarioService
se implementa una clase de tipo interfaz para generar el
metodo de guardar Usuario

28/10/2021
@jhoandrojas
 */


package co.edu.ucundinamarca.negocio.registro.service;
import co.edu.ucundinamarca.negocio.registro.model.Usuario;

public interface IUsuarioService {
    public Usuario guardar(Usuario usuario);
}
