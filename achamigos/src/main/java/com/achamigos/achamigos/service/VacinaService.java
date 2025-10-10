/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.achamigos.achamigos.service;
import com.achamigos.achamigos.model.Vacina;
import com.achamigos.achamigos.repository.VacinaRepository;
import org.springframework.stereotype.Service;
import com.achamigos.achamigos.exception.ResourceNotFoundException;
import java.util.List;

/**
 *
 * @author Alunos
 */
@Service
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    public Vacina cadastrarVacina(Vacina vacina) {
        return vacinaRepository.save(vacina);
    }

    public List<Vacina> listarTodas() {
        return vacinaRepository.findAll();
    }

    public List<Vacina> buscarPorAnimal(String animalId) {
        return vacinaRepository.findByAnimalId(animalId);
    }

    public Vacina buscarPorCodigo(String codVacina){
        return vacinaRepository.findByCodVacina(codVacina)
                .orElseThrow(() -> new ResourceNotFoundException("Vacina não encontrada com código: " + codVacina));
    }
    public Vacina buscarPorId(String id){
        return vacinaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vacina não encontrada com código: " + id));
    }

    public Vacina atualizarVacina(String codVacina, Vacina vacinaAtualizada) {
        Vacina vacina = buscarPorCodigo(codVacina);

        vacina.setNome(vacinaAtualizada.getNome());
        vacina.setDuracao(vacinaAtualizada.getDuracao());

        return vacinaRepository.save(vacina);
    }

    public void deletarVacina(String codVacina) {
        Vacina vacina = buscarPorCodigo(codVacina);
        vacinaRepository.delete(vacina);
    }
}


