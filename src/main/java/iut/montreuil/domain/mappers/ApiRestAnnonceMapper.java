package iut.montreuil.domain.mappers;

import iut.montreuil.application.data.request.AnnonceRequest;
import iut.montreuil.domain.model.Annonce;
import iut.montreuil.infrastructure.adapter.entity.AnnonceEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Mapper
@DecoratedWith(ApiRestAnnonceMapperDecorator.class)
public interface ApiRestAnnonceMapper {
    Logger logger = LoggerFactory.getLogger(ApiRestAnnonceMapper.class);
    ApiRestAnnonceMapper INSTANCE = Mappers.getMapper(ApiRestAnnonceMapper.class );

    AnnonceEntity annonceRequestToAnnonceEntity(AnnonceRequest annonce);
    AnnonceEntity annonceToAnnonceEntity(Annonce annonce);
    Annonce annonceEntityToDto(AnnonceEntity annonceEntity);
    ArrayList<Annonce> annonceEntitiesToDtoList(ArrayList<AnnonceEntity> entities);


}
