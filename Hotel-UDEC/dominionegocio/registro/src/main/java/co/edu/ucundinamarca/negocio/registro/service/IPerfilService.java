/*
IPerfilService
se implementa una clase de tipo interfaz para generar el
metodo de guardar perfil


28/10/2021
@jhoandrojas
 */

package co.edu.ucundinamarca.negocio.registro.service;
import co.edu.ucundinamarca.negocio.registro.model.Perfil;

import java.util.List;


public interface IPerfilService {
    public Perfil guardar(Perfil perfil);
    public Perfil endId();
}
