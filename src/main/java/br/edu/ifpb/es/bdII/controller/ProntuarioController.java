package br.edu.ifpb.es.bdII.controller;

import br.edu.ifpb.es.bdII.entities.Prontuario;
import br.edu.ifpb.es.bdII.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService service;

    @PostMapping
    public Prontuario criar(@RequestBody Prontuario Prontuario) {
        return service.salvar(Prontuario);
    }

    @GetMapping
    public List<Prontuario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Prontuario> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/data")
    public Optional<Prontuario> buscarPorData(@RequestParam String data) {
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
