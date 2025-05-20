package br.edu.ifpb.es.bdII.config;

import br.edu.ifpb.es.bdII.entities.Psicologo;
import br.edu.ifpb.es.bdII.repository.PacienteRepository;
import br.edu.ifpb.es.bdII.repository.PsicologoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final PsicologoRepository psicologoRepository;

    public TestConfig(PsicologoRepository psicologoRepository, PacienteRepository pacienteRepository) {
        this.psicologoRepository = psicologoRepository;
    }

    @Override
    public void run(String... args) {
        Psicologo psicologo = new Psicologo("12345", "Elizabeth Cristina", "elizabeth@gmail.com", "123654");
        psicologoRepository.save(psicologo);
        System.out.println("Psicólogo salvo com sucesso!");
    }
}
