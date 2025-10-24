package com.achamigos.achamigos.service;
//cometario
import com.achamigos.achamigos.model.Vacina;
import com.achamigos.achamigos.repository.VacinaRepository;
import com.achamigos.achamigos.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    public Vacina cadastrarVacina(Vacina vacina) {
        vacinaRepository.findByCodVacina(vacina.getCodVacina())
                .ifPresent(v -> { throw new ResourceNotFoundException("Código de vacina já cadastrado."); });
        return vacinaRepository.save(vacina);
    }

    public List<Vacina> listarTodas() {
        return vacinaRepository.findAll();
    }

    public List<Vacina> buscarPorAnimal(String animalId) {
        return vacinaRepository.findByAnimalId(animalId);
    }

    public Vacina buscarPorCodigo(String codVacina) {
        return vacinaRepository.findByCodVacina(codVacina)
                .orElseThrow(() -> new ResourceNotFoundException("Vacina não encontrada com código: " + codVacina));
    }

    public Vacina buscarPorId(String id) {
        return vacinaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vacina não encontrada com ID: " + id));
    }

    public Vacina atualizarVacina(String id, Vacina vacinaAtualizada) {
        Vacina vacina = buscarPorId(id);
        vacina.setNome(vacinaAtualizada.getNome());
        vacina.setDuracao(vacinaAtualizada.getDuracao());
        vacina.setCodVacina(vacinaAtualizada.getCodVacina());
        vacina.setAnimalId(vacinaAtualizada.getAnimalId());
        return vacinaRepository.save(vacina);
    }

    public void deletarVacina(String id) {
        Vacina vacina = buscarPorId(id);
        vacinaRepository.delete(vacina);
    }
}