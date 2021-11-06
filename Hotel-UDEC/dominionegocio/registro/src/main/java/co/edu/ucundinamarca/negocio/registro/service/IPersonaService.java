/*
IPersonaService
se implementa una clase de tipo interfaz para generar el
metodo de guardar Persona

28/10/2021
@jhoandrojas
 */


package co.edu.ucundinamarca.negocio.registro.service;
import co.edu.ucundinamarca.negocio.registro.model.Persona;

public interface IPersonaService {
    public Persona guardar(Persona persona);
    public Persona endId();
}
