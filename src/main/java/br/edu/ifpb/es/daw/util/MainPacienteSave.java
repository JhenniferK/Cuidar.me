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

        paciente.setNome("Joyce Gregório");
        paciente.setCpf("123.234.345-45");
        paciente.setRg("1234567");
        paciente.setTelefonePessoal("(83) 98765-4321");

        Endereco endereco = new Endereco();
        endereco.setCidade("Esperança");
        endereco.setEstado("Paraíba");
        endereco.setLogradouro("Manoel Carlos");
        endereco.setNumero(45);
        paciente.setEnderecoPessoal(endereco);

        Endereco endereco2 = new Endereco();
        endereco2.setCidade("Remígio");
        endereco2.setEstado("Paraíba");
        endereco2.setLogradouro("Ranieri Vitório");
        endereco2.setNumero(200);
        paciente.setEnderecoTrabalho(endereco2);
        paciente.setInfoAdicionais("Precisa de medicamentos");

        ContatoEmergencia contatoEmergencia = new ContatoEmergencia();
        contatoEmergencia.setNome("Jhennifer Kelly");
        contatoEmergencia.setTelefone("(83) 12345-6789");
        paciente.setContatoEmergencia(contatoEmergencia);

        System.out.println(paciente);
        pacienteDAO.save(paciente);
        System.out.println("Paciente " + paciente.getNome() + " salvo");
    }
}
