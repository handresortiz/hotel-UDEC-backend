package co.edu.ucundinamarca.negocio.login.controller;


import co.edu.ucundinamarca.negocio.login.model.EnumRol;
import co.edu.ucundinamarca.negocio.login.model.Persona;
import co.edu.ucundinamarca.negocio.login.model.Rol;
import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.repository.PersonaRepository;
import co.edu.ucundinamarca.negocio.login.repository.RolRespository;
import co.edu.ucundinamarca.negocio.login.repository.UsuarioRepository;
import co.edu.ucundinamarca.negocio.login.security.jwt.JwtUtils;
import co.edu.ucundinamarca.negocio.login.security.payload.request.LoginRequest;
import co.edu.ucundinamarca.negocio.login.security.payload.request.SignupRequest;
import co.edu.ucundinamarca.negocio.login.security.payload.response.JwtResponse;
import co.edu.ucundinamarca.negocio.login.security.payload.response.MessageResponse;
import co.edu.ucundinamarca.negocio.login.security.services.UserDetailsImpl;
import co.edu.ucundinamarca.negocio.login.service.UsurioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", value = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UsurioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    RolRespository rolRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getClave()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getLogin(),
                userDetails.getPersona().getPri_nombre(),
                userDetails.getPersona().getPri_apellido(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (usuarioRepository.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Este correo ya existe!"));
        }


        if (personaRepository.existsByIdentificacion(signUpRequest.getIdentificacion())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Esta identificacion ya esta siendo usada por otra persona!"));
        }

        // Create new user's account
        Persona user = new Persona(
                signUpRequest.getPri_nombre(),
                signUpRequest.getSeg_nombre(),
                signUpRequest.getPri_apellido(),
                signUpRequest.getSeg_apellido(),
                signUpRequest.getRazon_social(),
                signUpRequest.getTelefono(),
                signUpRequest.getDireccion(),
                signUpRequest.getLogin(),
                signUpRequest.getIdentificacion(),
                signUpRequest.getGenero());


        personaRepository.save(user);

        Usuario newUser = new Usuario(  encoder.encode(signUpRequest.getClave()),
                                        signUpRequest.getLogin(),
                                        personaRepository.lastPerson());


        List<String> strRoles = signUpRequest.getRole();
        List<Rol> roles = new ArrayList<>();

        if (strRoles == null) {
            Rol userRole = rolRepository.findByNomRol("ROLE_CLIENT")
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ROLE_ADMIN":
                        Rol adminRole = rolRepository.findByNomRol("ROLE_ADMIN")
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "ROLE_MODERATOR":
                        Rol modRole = rolRepository.findByNomRol("ROLE_MODERATOR")
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Rol userRole = rolRepository.findByNomRol("ROLE_CLIENT")
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        newUser.setRoles(roles);
        usuarioRepository.save(newUser);

        return ResponseEntity.ok(new MessageResponse("Te has registrado exitosamente!"));
    }

<<<<<<< HEAD

=======
>>>>>>> 1febac2d650993ee7c33fe8fd84a950161732a9f
    @GetMapping("/credentials")
    public ResponseEntity<?> getCredentials(@RequestParam String email){
        return ResponseEntity.ok( usuarioRepository.findByLogin(email));
    }
/*
Hecho por Carlos
 */
    /*
    @PostMapping("/validar/{login}/{clave}")
    public ResponseEntity<Usuario> validar(@PathVariable String login, @PathVariable String clave) {
        Usuario usuarioLogin=usuarioService.login(login, clave);
        System.out.println(usuarioLogin.getLogin());
        if(usuarioLogin==null){
            return new ResponseEntity(new Mensaje("el usuario no esta registrado"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(usuarioLogin);

    }

     */




    }
