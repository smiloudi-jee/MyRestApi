package iut.montreuil.application.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Home {
    private String firstName;
    private String lastName;
}
