package iut.montreuil.application.data.request;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class AnnonceRequest {

    private String title;
    private String description;
    private String address;
    private String mail;
    private String date;
}
