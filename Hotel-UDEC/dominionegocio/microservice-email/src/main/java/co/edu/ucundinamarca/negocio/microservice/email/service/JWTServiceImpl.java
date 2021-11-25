package co.edu.ucundinamarca.negocio.microservice.email.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JWTServiceImpl implements JWTService {

    public static final String SECRET = Base64Utils.encodeToString("ThisIsAMost.ImportantSecretAboutJwTFor.H0t31UD3c.123".getBytes());

    public static final long EXPIRATION_DATE = 7200000L;

    public static final String TOKEN_PREFIX =  "Bearer ";




    @Override
    public String create() throws JsonProcessingException {

        SecretKey secretKey = new SecretKeySpec(SECRET.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        String token = Jwts.builder()
                .signWith(secretKey)
                .setIssuedAt(new Date())
                .setExpiration(new Date( System.currentTimeMillis() + EXPIRATION_DATE )) //Es dos horas en milisegundos
                .compact();

        return token;
    }

    @Override
    public boolean validate(String token) {
        Claims claims = null;


        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex){
            return false;
        }
    }

    @Override
    public Claims getClaims(String token) {

        Claims claims =  Jwts.parser()
                .setSigningKey( SECRET.getBytes() )
                .parseClaimsJws(resolve(token))
                .getBody();

        return claims;
    }

    @Override
    public boolean equals(String token){
        return token.equals(SECRET);
    }

    @Override
    public String resolve(String token) {
        if(token != null && token.startsWith(TOKEN_PREFIX)){
            return token.replace( TOKEN_PREFIX , "");
        }
        return null;
    }
}
