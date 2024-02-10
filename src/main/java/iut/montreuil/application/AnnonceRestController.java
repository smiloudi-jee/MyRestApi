package iut.montreuil.application;

import iut.montreuil.application.data.request.AnnonceRequest;
import iut.montreuil.application.data.response.ServicesResponse;
import iut.montreuil.application.data.response.TypeResponse;
import iut.montreuil.application.port.IAnnonceServices;
import iut.montreuil.domain.model.Annonce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AnnonceRestController extends ParentRestController {

    private String message = "SUCCESS";
    private TypeResponse typeResponse = TypeResponse.OK;
    private Object bean = null;
    @Autowired
    private IAnnonceServices services;

    @GetMapping(path = "/list")
    public ResponseEntity<ServicesResponse> loadAllAnnonces() {
        try {
            bean = services.loadAllAnnonces();
        } catch (Exception e) {
            bean = e.getCause();
            message = e.getLocalizedMessage();
            typeResponse = TypeResponse.ERROR;
        }
        return buildResponseEntity(bean, typeResponse, message);

    }

    @GetMapping(path = "/findById/{taskId}", produces = "application/json")
    public ResponseEntity<ServicesResponse> findById(@PathVariable String taskId) {
        try {
            bean = services.findById(taskId);
        } catch (Exception e) {
            bean = e.getCause();
            message = e.getLocalizedMessage();
            typeResponse = TypeResponse.ERROR;
        }
        return buildResponseEntity(bean, typeResponse, message);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ServicesResponse> add(@RequestBody AnnonceRequest annonceRequest){
        try {
            bean = services.save(annonceRequest);
        } catch (Exception e) {
            bean = e.getCause();
            message = e.getLocalizedMessage();
            typeResponse = TypeResponse.ERROR;
        }
        return buildResponseEntity(bean, typeResponse, message);
    }

    @DeleteMapping(path = "/delete/{idAnnonce}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ServicesResponse> remove(@PathVariable String idAnnonce){
        try {
            services.deleteById(idAnnonce);
        } catch (Exception e) {
            bean = e.getCause();
            message = e.getLocalizedMessage();
            typeResponse = TypeResponse.ERROR;
        }
        return buildResponseEntity(bean, typeResponse, message);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ServicesResponse> update(@RequestBody Annonce toUpdate){
        try {
            bean = services.updateAnnonce(toUpdate);
        } catch (Exception e) {
            bean = e.getCause();
            message = e.getLocalizedMessage();
            typeResponse = TypeResponse.ERROR;
        }
        return buildResponseEntity(bean, typeResponse, message);
    }

}
