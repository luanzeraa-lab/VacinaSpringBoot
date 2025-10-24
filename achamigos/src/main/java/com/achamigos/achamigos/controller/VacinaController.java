package com.achamigos.achamigos.controller;

import com.achamigos.achamigos.model.Vacina;
import com.achamigos.achamigos.service.VacinaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//comentario aleatorio
@RestController
@RequestMapping("/api/vacinas")
@CrossOrigin(origins = "*")
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

    @GetMapping("codigo/{codVacina}")
    public Vacina buscarPorCodigo(@PathVariable("codVacina") String codVacina) {
        return vacinaService.buscarPorCodigo(codVacina);
    }

    @GetMapping("/{id}")
    public Vacina buscarPorId(@PathVariable("id") String id) {
        return vacinaService.buscarPorId(id);
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
