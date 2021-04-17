package net.vpein.mailing.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.hateoas.RepresentationModel;

@Log
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
public class Mail extends RepresentationModel<Mail> {

    //private @Id Long id; // will be set when persisting

    private String fromAdr;
    private String toAdr;
    private String subject;
    private String simpleText;
    private String htmlText;

    //"Hateoas" Constructor
    @JsonCreator
    public Mail(@JsonProperty("fromAdr") String fromAdr,
                @JsonProperty("toAdr") String toAdr,
                @JsonProperty("subject") String subject,
                @JsonProperty("simpleText") String simpleText,
                @JsonProperty("htmlText") String htmlText) {
        this.fromAdr = fromAdr;
        this.toAdr = toAdr;
        this.subject = subject;
        this.simpleText = simpleText;
        this.htmlText = htmlText;

    }


}

