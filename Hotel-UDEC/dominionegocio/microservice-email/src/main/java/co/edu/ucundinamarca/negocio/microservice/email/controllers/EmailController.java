package co.edu.ucundinamarca.negocio.microservice.email.controllers;


import co.edu.ucundinamarca.negocio.microservice.email.entities.EmailSend;
import co.edu.ucundinamarca.negocio.microservice.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    MailService mailService;

    @PostMapping("/send")
    public String send(@RequestBody EmailSend emailSend) throws IOException {
        return mailService.sentTestTextEmail(emailSend.getName(), emailSend.getTo());
    }


}
