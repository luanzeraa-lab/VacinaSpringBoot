package com.achamigos.achamigos.controller;

import com.achamigos.achamigos.model.Vacinacao;
import com.achamigos.achamigos.service.VacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vacinacao")
public class VacinacaoController {

    @Autowired
    private VacinacaoService vacinacaoService;

    @GetMapping
    public List<Map<String, Object>> listarTodas() {
        return vacinacaoService.listarTodas();
    }

    @PostMapping
    public Vacinacao criar(@RequestBody Vacinacao vacinacao) {
        return vacinacaoService.salvar(vacinacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        vacinacaoService.deletar(id);
    }
}