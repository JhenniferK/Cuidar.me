package br.edu.ifpb.es.bdII.controller;

import br.edu.ifpb.es.bdII.entities.Psicologo;
import br.edu.ifpb.es.bdII.service.PsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/psicologo")
public class PsicologoController {

    @Autowired
    private PsicologoService service;

    @PostMapping
    public Psicologo criar(@RequestBody Psicologo Psicologo) {
        return service.salvar(Psicologo);
    }
}
