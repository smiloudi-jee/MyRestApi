package iut.montreuil.application;

import iut.montreuil.application.data.request.AuthenticationRequest;
import iut.montreuil.application.data.response.Home;
import iut.montreuil.application.data.response.ServicesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class HomeRestController extends ParentRestController {

    @GetMapping(path = "/home")
    public ResponseEntity<ServicesResponse> home() {
        bean = Home.builder().lastName("lastName").firstName("firstName").build();
        return buildResponseEntity(bean, typeResponse, message);
    }

    @PostMapping(path = "/login", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest){
        System.out.println(authenticationRequest.toString());

        String basicAuth =
                "Basic " + Base64.getEncoder().encodeToString(authenticationRequest.toEncode());
        return ResponseEntity.ok(basicAuth);
    }
}
