package iut.montreuil.infrastructure.adapter.repository;

import iut.montreuil.infrastructure.adapter.entity.AnnonceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface IAnnonceRepository
        extends JpaRepository<AnnonceEntity, BigInteger> {

}
