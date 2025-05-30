package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.dao.PacienteDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.PacienteDAOImpl;
import br.edu.ifpb.es.daw.entities.ContatoEmergencia;
import br.edu.ifpb.es.daw.entities.Endereco;
import br.edu.ifpb.es.daw.entities.Paciente;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPacienteSave {
    public static void main(String[] args) throws PersistenciaDawException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        PacienteDAO pacienteDAO = new PacienteDAOImpl(emf);
        Paciente paciente = new Paciente();

        paciente.setCpf(12345678900L);
        paciente.setNome("Joyce Gregório");

        ContatoEmergencia contatoEmergencia = new ContatoEmergencia();
        contatoEmergencia.setNome("Jhennifer");
        contatoEmergencia.setTelefone(232455667);

        paciente.setContatoEmergencia(contatoEmergencia);

        Endereco endereco = new Endereco();
        endereco.setCidade("Esperança");
        endereco.setEstado("Paraíba");
        endereco.setLogradouro("Manoel Carlos");
        endereco.setNumero(45);
        paciente.setEnderecoPessoal(endereco);

        Endereco endereco2 = new Endereco();
        endereco2.setCidade("Esperança");
        endereco2.setEstado("Paraíba");
        endereco2.setLogradouro("Manoel Carlos");
        endereco2.setNumero(45);
        paciente.setEnderecoTrabalho(endereco2);
        paciente.setInfo_adicionais("Precisa de medicamentos");

        System.out.println(paciente);
        pacienteDAO.save(paciente);
        System.out.println("Paciente " + paciente.getNome() + " salvo");
    }
}
