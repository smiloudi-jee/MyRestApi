package iut.montreuil.domain.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ApiRestAnnonceMapperDecorator implements ApiRestAnnonceMapper {
    private final static Logger logger = LoggerFactory.getLogger(ApiRestAnnonceMapperDecorator.class);
    private final ApiRestAnnonceMapper delegate;
    public ApiRestAnnonceMapperDecorator(ApiRestAnnonceMapper delegate) {
        this.delegate = delegate;
    }


}
