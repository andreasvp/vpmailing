package net.vpein.mailing.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import net.vpein.mailing.domain.Mail;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @RequestMapping("/mail")
    public HttpEntity<Mail> mail(
            @RequestParam(value = "from", defaultValue = "test2@test.net") String from) {

        String to = "Test@test.net";
        String sub = "Testsubject";
        String stext = "Hi Test,\nwas geht?\nDein Abo";
        String htext = "<h1>Hi Test,</h1><p>was geht?</p><p>Dein Abo</p>";

        Mail mail = new Mail(from, to, sub, stext, htext);
        mail.add(linkTo(methodOn(MainController.class).mail(from)).withSelfRel());

        return new ResponseEntity<>(mail, HttpStatus.OK);
    }

}
