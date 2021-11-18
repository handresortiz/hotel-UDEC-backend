package co.edu.ucundinamarca.negocio.login.auth.filter;

import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.service.JWTService;
import co.edu.ucundinamarca.negocio.login.service.JWTServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private JWTService jwtService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher( new AntPathRequestMatcher("/login","POST"));
        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if ( username != null && password != null){
            logger.info("Username desde request (form-data): " + username);
            logger.info("Password desde request (form-data): "+password);
        } else {
            try{
                Usuario user = new ObjectMapper().readValue( request.getInputStream(), Usuario.class);
                username = user.getLogin();
                password = user.getClave();

                logger.info( "username desde InpuTStream (raw):  "+username);
                logger.info( "Password desde InputStream (raw):  "+password);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,password);

        return authenticationManager.authenticate((authToken));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = jwtService.create(authResult);

        response.addHeader(JWTServiceImpl.HEADRE_STRING, JWTServiceImpl.TOKEN_PREFIX + token );

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("token",token);
        body.put("user", (User) authResult.getPrincipal());
        body.put("mensaje", String.format("Hola %s, has iniciado sesion con éxito!", ( ((User) authResult.getPrincipal()).getUsername() )));

        response.getWriter().write( new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("mensaje", "Error de autenticacion, username o password inválidos");
        body.put("error", failed.getMessage());
        response.getWriter().write( new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType("application/json");
    }
}
