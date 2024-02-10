package iut.montreuil.application.port;

import iut.montreuil.application.data.request.AnnonceRequest;
import iut.montreuil.domain.model.Annonce;

import java.util.List;

public interface IAnnonceServices {

    List<Annonce> loadAllAnnonces();
    Annonce findById (String idAnnonce);
    Annonce save(AnnonceRequest annonceRequest);
    void deleteById(String idAnnonce);
    Annonce updateAnnonce(Annonce toUpdate);
}
