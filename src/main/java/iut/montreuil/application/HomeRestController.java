package iut.montreuil.application;

import iut.montreuil.application.data.response.Home;
import iut.montreuil.application.data.response.ServicesResponse;
import iut.montreuil.application.data.response.TypeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController extends ParentRestController {

    @GetMapping(path = "/home")
    public ResponseEntity<ServicesResponse> home() {
        bean = Home.builder().lastName("lastName").firstName("firstName").build();
        return buildResponseEntity(bean, typeResponse, message);
    }
}
