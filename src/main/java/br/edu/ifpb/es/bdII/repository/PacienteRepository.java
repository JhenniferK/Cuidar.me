package br.edu.ifpb.es.bdII.repository;

import br.edu.ifpb.es.bdII.entities.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Optional<Paciente> findByCpf(Long cpf);
    void deleteByCpf(Long cpf);
}
