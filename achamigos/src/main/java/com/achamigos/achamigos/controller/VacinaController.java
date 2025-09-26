/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.achamigos.achamigos.controller;

/**
 *
 * @author Alunos
 */
import com.achamigos.achamigos.model.Vacina;
import com.achamigos.achamigos.service.VacinaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {

    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    @PostMapping
    public Vacina cadastrar(@RequestBody Vacina vacina) {
        return vacinaService.cadastrarVacina(vacina);
    }

    @GetMapping
    public List<Vacina> listar() {

        return vacinaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Vacina buscarPorCodigo(@PathVariable("id") String codVacina) {

        return vacinaService.buscarPorCodigo(codVacina);
    }

    @GetMapping("/animal/{animalId}")
    public List<Vacina> buscarPorAnimal(@PathVariable String animalId) {
        return vacinaService.buscarPorAnimal(animalId);
    }

    @PutMapping("/{id}")
    public Vacina atualizar(@PathVariable("id") String id, @RequestBody Vacina vacina) {
        return vacinaService.atualizarVacina(id, vacina);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id) {
        vacinaService.deletarVacina(id);
    }
}
