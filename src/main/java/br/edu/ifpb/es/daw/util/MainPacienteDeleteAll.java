package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.DawException;
import br.edu.ifpb.es.daw.dao.PacienteDAO;
import br.edu.ifpb.es.daw.dao.impl.PacienteDAOImpl;
import br.edu.ifpb.es.daw.entities.Paciente;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPacienteDeleteAll {
    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")){
            PacienteDAO pacienteDAO = new PacienteDAOImpl(emf);
            List<Paciente> pacientes = pacienteDAO.getAll();
            for(Paciente paciente : pacientes){
                pacienteDAO.delete(paciente.getCpf());
            }
        }
    }
}
