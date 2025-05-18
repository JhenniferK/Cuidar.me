package br.edu.ifpb.es.bdII.repository;

import br.edu.ifpb.es.bdII.entities.Prontuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ProntuarioRepository extends MongoRepository<Prontuario, String> {
    Optional<Prontuario> findByDataRegistro(LocalDateTime dataRegistro);
    void deleteByDataRegistro(LocalDateTime dataRegistro);
}
