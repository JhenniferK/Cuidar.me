package br.edu.ifpb.es.bdII.repository;

import br.edu.ifpb.es.bdII.entities.Atendimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.Optional;

public interface AtendimentoRepository extends MongoRepository<Atendimento, String> {
    Optional<Atendimento> findByData(LocalDateTime data);
    void deleteByData(LocalDateTime data);
}
