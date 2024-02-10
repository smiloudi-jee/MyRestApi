package iut.montreuil.domain.service;

import iut.montreuil.application.data.request.AnnonceRequest;
import iut.montreuil.application.port.IAnnonceServices;
import iut.montreuil.domain.mappers.ApiRestAnnonceMapper;
import iut.montreuil.domain.model.Annonce;
import iut.montreuil.infrastructure.adapter.entity.AnnonceEntity;
import iut.montreuil.infrastructure.adapter.repository.IAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceServicesImpl implements IAnnonceServices {
    @Autowired
    private IAnnonceRepository repository;

    @Override
    public List<Annonce> loadAllAnnonces() {
        List<AnnonceEntity> entities = repository.findAll();
        return ApiRestAnnonceMapper.INSTANCE.annonceEntitiesToDtoList( new ArrayList<>(entities) );
    }

    @Override
    public Annonce findById(String idAnnonce) {
        Optional<AnnonceEntity> entity = repository.findById( new BigInteger(idAnnonce) );
        return entity.isEmpty() ? null : ApiRestAnnonceMapper.INSTANCE.annonceEntityToDto(entity.get());
    }

    @Override
    public Annonce save(AnnonceRequest annonceRequest) {
        AnnonceEntity entity =
                ApiRestAnnonceMapper.INSTANCE.annonceRequestToAnnonceEntity(annonceRequest);
        return ApiRestAnnonceMapper.INSTANCE.annonceEntityToDto(repository.save(entity));
    }

    @Override
    public void deleteById(String idAnnonce) {
        repository.deleteById(new BigInteger(idAnnonce));
    }

    @Override
    public Annonce updateAnnonce(Annonce toUpdate) {
        AnnonceEntity entity =
                ApiRestAnnonceMapper.INSTANCE.annonceToAnnonceEntity(toUpdate);
        return ApiRestAnnonceMapper.INSTANCE.annonceEntityToDto(repository.save(entity));
    }
}
