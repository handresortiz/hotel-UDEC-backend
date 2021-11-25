package co.edu.ucundinamarca.negocio.microservice.email.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;


public interface JWTService {

    public String create() throws JsonProcessingException;

    public boolean validate(String token);

    public Claims getClaims(String token);

    public String resolve(String token);

    public boolean equals(String token);

}
