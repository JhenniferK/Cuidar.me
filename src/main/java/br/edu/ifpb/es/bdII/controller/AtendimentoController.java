package br.edu.ifpb.es.bdII.controller;

import br.edu.ifpb.es.bdII.entities.Atendimento;
import br.edu.ifpb.es.bdII.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService service;

    @PostMapping
    public Atendimento criar(@RequestBody Atendimento atendimento) {
        return service.salvar(atendimento);
    }

    @GetMapping
    public List<Atendimento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Atendimento> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/data")
    public Optional<Atendimento> buscarPorData(@RequestParam String data) {
        return service.buscarPorData(LocalDateTime.parse(data));
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable String id) {
        service.deletarPorId(id);
    }

    @DeleteMapping("/data")
    public void deletarPorData(@RequestParam String data) {
        service.deletarPorData(LocalDateTime.parse(data));
    }
}
