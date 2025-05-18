package br.edu.ifpb.es.bdII.controller;

import br.edu.ifpb.es.bdII.entities.Pagamento;
import br.edu.ifpb.es.bdII.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping
    public Pagamento criar(@RequestBody Pagamento Pagamento) {
        return service.salvar(Pagamento);
    }

    @GetMapping
    public List<Pagamento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pagamento> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable String id) {
        service.deletarPorId(id);
    }
}
