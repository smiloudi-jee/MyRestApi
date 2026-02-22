package iut.montreuil.infrastructure.adapter.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@DynamicUpdate
@Table(name = "ANNONCE")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnnonceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "2"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "DATE")
    private String date;

}
