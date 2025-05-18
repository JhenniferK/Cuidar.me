package br.edu.ifpb.es.bdII.repository;

import br.edu.ifpb.es.bdII.entities.Psicologo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PsicologoRepository extends MongoRepository<Psicologo, String> {
    Optional<Psicologo> findByCrp(Long crp);
    void deleteByCrp(Long crp);
}
