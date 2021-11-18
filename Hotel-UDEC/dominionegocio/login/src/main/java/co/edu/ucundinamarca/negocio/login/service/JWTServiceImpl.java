package co.edu.ucundinamarca.negocio.login.service;

import co.edu.ucundinamarca.negocio.login.auth.SimpleGrantedAuthorityMixin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Component
public class JWTServiceImpl implements JWTService{

    public static final String SECRET = Base64Utils.encodeToString("ThisIsAMost.ImportantSecretAboutJwTFor.H0t31UD3c.123".getBytes());

    public static final long EXPIRATION_DATE = 7200000L;

    public static final String TOKEN_PREFIX =  "Bearer ";

    public static final String HEADRE_STRING = "Authorization";


    @Override
    public String create(Authentication auth) throws JsonProcessingException {
        String username = ((User) auth.getPrincipal()).getUsername();
        SecretKey secretKey = new SecretKeySpec( SECRET.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        Collection<? extends GrantedAuthority> roles = auth.getAuthorities();

        Claims claims = Jwts.claims();

        claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .signWith(secretKey)
                .setIssuedAt( new Date())
                .setExpiration( new Date( System.currentTimeMillis() + EXPIRATION_DATE)) // Esto es en milisegundos
                .compact();

        return token;
    }

    @Override
    public boolean validate(String token) {

        Claims claims = null;

        try{
            getClaims(token);
            return true;
        } catch( JwtException | IllegalArgumentException ex){
            return false;
        }
    }

    @Override
    public Claims getClaims(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey( SECRET.getBytes() )
                .parseClaimsJws( resolve(token))
                .getBody();

        return claims;
    }

    @Override
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    @Override
    public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {
        Object roles = getClaims((token)).get("authorities");

        Collection<? extends GrantedAuthority> authorities = Arrays.asList(new ObjectMapper()
                .addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
                .readValue( roles.toString().getBytes(), SimpleGrantedAuthority[].class));
        return authorities;
    }

    @Override
    public String resolve(String token) {
        if( token != null && token.startsWith(TOKEN_PREFIX)){
            return token.replace( TOKEN_PREFIX, "");
        }
        return null;
    }
}
