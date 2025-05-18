package br.edu.ifpb.es.bdII.repository;

import br.edu.ifpb.es.bdII.entities.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PagamentoRepository extends MongoRepository<Pagamento, String> {
    Optional<Pagamento> findById(String id);
    void deleteById(String id);
}
