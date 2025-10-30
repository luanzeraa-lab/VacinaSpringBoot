package com.achamigos.achamigos.service;



import com.achamigos.achamigos.model.Vacinacao;
import com.achamigos.achamigos.repository.VacinacaoRepository;
import com.achamigos.achamigos.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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

            Query query = new Query(Criteria.where("_id").is(v.getAnimalId()));
            Map<String, Object> animal = mongoTemplate.findOne(query, Map.class, "animais");

            vacinaRepository.findById(v.getVacinaId()).ifPresent(vc ->
                    item.put("vacina", vc)
            );

            item.put("animal", animal);
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
}