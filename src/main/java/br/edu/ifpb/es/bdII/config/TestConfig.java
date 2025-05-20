package br.edu.ifpb.es.bdII.config;

import br.edu.ifpb.es.bdII.entities.ContatoEmergencia;
import br.edu.ifpb.es.bdII.entities.Endereco;
import br.edu.ifpb.es.bdII.entities.Paciente;
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
    private final PacienteRepository pacienteRepository;

    public TestConfig(PsicologoRepository psicologoRepository, PacienteRepository pacienteRepository) {
        this.psicologoRepository = psicologoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void run(String... args) {
        Psicologo psicologo = new Psicologo("12345", "Elizabeth Cristina", "elizabeth@gmail.com", "123654");
        Endereco enderecoPessoal = new Endereco("Rua Ranieri Rodrigues", 200, "Remígio", "Paraíba");
        Endereco enderecoTrabalho = new Endereco("Rua Manoel Bento", 301, "Remígio", "Paraíba");
        ContatoEmergencia contatoEmergencia = new ContatoEmergencia("Jônatas", "83123456789");
        Paciente paciente = new Paciente("Jhennifer Kelly", "123.456.789-00", "1.234-567", enderecoPessoal, enderecoTrabalho, "83123456789", contatoEmergencia);
        psicologoRepository.save(psicologo);
        pacienteRepository.save(paciente);
        System.out.println("Psicólogo salvo com sucesso!");
        System.out.println("Paciente salvo com sucesso!");
    }
}
