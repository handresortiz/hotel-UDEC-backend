/*
Mensaje
en esta clase se implementa un atributo mensaje para porder utilizar en la rest para los response.


28/10/2021
@jhoandrojas
 */


package co.edu.ucundinamarca.negocio.registro.rest;


public class Mensaje {

    private String mensaje;

    public Mensaje(String mensaje  ) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
