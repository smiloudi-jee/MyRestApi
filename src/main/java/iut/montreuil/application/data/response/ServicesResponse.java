package iut.montreuil.application.data.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ServicesResponse {
    @Builder.Default
    private TypeResponse typeResponse = TypeResponse.OK;
    private Object bean;
    private String message;
}
