package co.edu.ucundinamarca.negocio.microservice.email.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

public interface JWTService {

    public String create(String email) throws JsonProcessingException;

    public boolean validate(String token);

    public Claims getClaims(String token);

    public String resolve(String token);

}
