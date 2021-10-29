package co.edu.ucundinamarca.negocio.microservice.email.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    public String sentTestTextEmail() throws IOException {
        // the sender email should be the same as we used to Create a Single Sender Verification
        Email from = new Email("dmattcomics@gmail.com");
        String subject = "Test";
        Email to = new Email("cristiancamilogarzon2@gmail.com");
        Content content = new Content("text/plain", "This is a test, from Spring twice was send email");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            logger.info(response.getBody());
            return response.getBody();
        } catch (IOException ex) {
            throw ex;
        }
    }

}
