package iut.montreuil.domain.model;

import lombok.*;

import javax.persistence.Column;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Annonce {

    private Integer id;
    private String title;
    private String description;
    private String address;
    private String mail;
    private String date;
}
