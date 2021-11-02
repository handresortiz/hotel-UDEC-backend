/*
PersonaService

se inyecta el objeto con un @Autowired
y se implementa una funcion de tipo Usuario, llamando a PersonaRepository para traer el metodo de guardar
ya definido en IUsuarioService

se implementa los metodos donde con una condicion se verifica si existe o no el un username, en caso tal que
exista envia un mensaje de que ese dato ya existe.

28/10/2021
@jhoandrojas
 */


package co.edu.ucundinamarca.negocio.registro.service;
import co.edu.ucundinamarca.negocio.registro.model.Usuario;
import co.edu.ucundinamarca.negocio.registro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean existsByLogin(String login){
        return usuarioRepository.existsByLogin(login);
    }


}
