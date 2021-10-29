package co.edu.ucundinamarca.negocio.microservice.email.controllers;


import co.edu.ucundinamarca.negocio.microservice.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    MailService mailService;

    @GetMapping("/test")
    public String quickback(){
     return "Sisisi";
 }

    @PostMapping("/send")
    public String send() throws IOException {
        return mailService.sentTestTextEmail();
    }
}
