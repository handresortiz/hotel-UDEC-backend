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
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    public String sentTestTextEmail() throws IOException {
        // the sender email should be the same as we used to Create a Single Sender Verification
        Email from = new Email("dmattcomics@gmail.com");
        Email to = new Email("huesitos-221@hotmail.com");

        Mail mail = new Mail();

        // I try to keep every think simple
        DynamicTemplatePersonalization personalization = new DynamicTemplatePersonalization();
        personalization.addTo(to);
        mail.setFrom(from);
        mail.setSubject("test email");
        // This is the first_name variable that we created on the template
        personalization.addDynamicTemplateData("first_name", "Daniel");
        mail.addPersonalization(personalization);
        mail.setTemplateId("d-d9f5f324a5ed4ff084f89afd5c8b6fa0");

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
