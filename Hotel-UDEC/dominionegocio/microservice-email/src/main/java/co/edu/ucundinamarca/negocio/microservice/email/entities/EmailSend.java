package co.edu.ucundinamarca.negocio.microservice.email.entities;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class EmailSend {

    @Email
    private String to;

    @NotNull
    private String name;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
