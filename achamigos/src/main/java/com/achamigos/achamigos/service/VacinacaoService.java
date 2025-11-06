package com.achamigos.achamigos.service;



import com.achamigos.achamigos.model.Vacinacao;
import com.achamigos.achamigos.model.Vacina;
import com.achamigos.achamigos.repository.VacinacaoRepository;
import com.achamigos.achamigos.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.*;

@Service
public class VacinacaoService {

    @Autowired
    private VacinacaoRepository vacinacaoRepository;

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Map<String, Object>> listarTodas() {
        List<Vacinacao> vacinacao = vacinacaoRepository.findAll();
        List<Map<String, Object>> resultado = new ArrayList<>();

        for (Vacinacao v : vacinacao) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", v.getId());
            item.put("dataAplicacao", v.getDataAplicacao());
            item.put("animalId", v.getAnimalId());
            item.put("vacinaId", v.getVacinaId());

            resultado.add(item);
        }

        return resultado;
    }

    public Vacinacao salvar(Vacinacao vacinacao) {
        return vacinacaoRepository.save(vacinacao);
    }

    public void deletar(String id) {
        vacinacaoRepository.deleteById(id);
    }

    @Autowired
    private AnimalRepository animalRepository;

    public List<Vacinacao> gerarPorAnimal(String animalId) {
        Optional<Animal> optionalAnimal = animalRepository.findById(animalId);

        if (optionalAnimal.isEmpty()) {
            throw new NoSuchElementException("Animal não encontrado com ID: " + animalId);
        }

        Animal animal = optionalAnimal.get();
        String animalNome = animal.getNome();
        List<Vacina> vacinas = animal.getVacinas();

        List<Vacinacao> vacinacoesCriadas = new ArrayList<>();

        if (vacinas == null || vacinas.isEmpty()) {
            return vacinacoesCriadas;
        }

        for (Vacina vacina : vacinas) {
            Vacinacao nova = new Vacinacao();
            nova.setAnimalId(animalId);
            nova.setAnimalNome(animalNome);
            nova.setVacinaId(vacina.getId());
            nova.setVacinaNome(vacina.getNome());
            nova.setDataAplicacao(LocalDate.now());

            vacinacaoRepository.save(nova);
            vacinacoesCriadas.add(nova);
        }

        return vacinacoesCriadas;
    }
}
