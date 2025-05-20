package br.edu.ifpb.es.bdII.service;

import br.edu.ifpb.es.bdII.entities.Psicologo;
import br.edu.ifpb.es.bdII.repository.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsicologoService {

    @Autowired
    private PsicologoRepository repository;

    public Psicologo salvar(Psicologo Psicologo) {
        return repository.save(Psicologo);
    }
}