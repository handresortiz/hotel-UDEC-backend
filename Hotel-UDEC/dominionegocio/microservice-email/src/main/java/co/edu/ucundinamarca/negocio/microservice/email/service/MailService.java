package co.edu.ucundinamarca.negocio.microservice.email.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailService {

    @Autowired
    private JWTService jwtService;

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @Value("${spring.sendgrid.api-key}") String sendGripApiKey;

    @Value("${sendgrid.template.id}") String templateId;


    public String sentTestTextEmail(String name, String To) throws IOException {
        // the sender email should be the same as we used to Create a Single Sender Verification
        Email from = new Email("huesitos-221@hotmail.com");
        Mail mail = new Mail();
        Email to = new Email(To);
        // I try to keep every think simple
        DynamicTemplatePersonalization personalization = new DynamicTemplatePersonalization();
        personalization.addTo(to);
        mail.setFrom(from);
        mail.setSubject("Email of verification");
        // This is the first_name variable that we created on the template
        personalization.addDynamicTemplateData("first_name", name);
        personalization.addDynamicTemplateData("token", jwtService.create());
        mail.addPersonalization(personalization);
        mail.setTemplateId(templateId);

        SendGrid sg = new SendGrid(sendGripApiKey);
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
    // This class handels the dynamic data for the template
    // Feel free to customise this class our to putted on other file
    private static class DynamicTemplatePersonalization extends Personalization {

        @JsonProperty(value = "dynamic_template_data")
        private Map<String, Object> dynamic_template_data;

        @JsonProperty("dynamic_template_data")
        public Map<String, Object> getDynamicTemplateData() {
            if (dynamic_template_data == null) {
                return Collections.<String, Object>emptyMap();
            }
            return dynamic_template_data;
        }

        public void addDynamicTemplateData(String key, String value) {
            if (dynamic_template_data == null) {
                dynamic_template_data = new HashMap<String, Object>();
                dynamic_template_data.put(key, value);
            } else {
                dynamic_template_data.put(key, value);
            }
        }

    }

}
