package iut.montreuil.application;

import iut.montreuil.application.data.response.ServicesResponse;
import iut.montreuil.application.data.response.TypeResponse;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public abstract class ParentRestController {

    protected String message = "SUCCESS";
    protected TypeResponse typeResponse = TypeResponse.OK;
    protected Object bean = null;

    protected ResponseEntity buildResponseEntity(Object o, TypeResponse typeResponse, String message) {
        if(TypeResponse.ERROR.equals(typeResponse))
            return ResponseEntity.internalServerError().body(buildResponse(o, typeResponse, message));
        if(!Objects.isNull(o))
            return ResponseEntity.ok().body(buildResponse(o, typeResponse, message));
        return ResponseEntity.notFound().build();
    }

    private ServicesResponse buildResponse(Object o, TypeResponse typeResponse, String message) {
        return ServicesResponse.builder()
                .bean(o)
                .typeResponse(typeResponse)
                .message(message)
                .build();
    }

}
