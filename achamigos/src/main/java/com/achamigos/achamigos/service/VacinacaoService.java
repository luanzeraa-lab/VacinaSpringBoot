package com.achamigos.achamigos.service;

import com.achamigos.achamigos.model.Vacinacao;
import com.achamigos.achamigos.repository.VacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.bson.Document;

import java.time.LocalDate;
import java.util.*;

@Service
public class VacinacaoService {

    @Autowired
    private VacinacaoRepository vacinacaoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // Lista todas as vacinações
    public List<Map<String, Object>> listarTodas() {
        List<Vacinacao> vacinacoes = vacinacaoRepository.findAll();
        List<Map<String, Object>> resultado = new ArrayList<>();

        for (Vacinacao v : vacinacoes) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", v.getId());
            item.put("animalId", v.getAnimalId());
            item.put("animalNome", v.getAnimalNome());
            item.put("vacinaId", v.getVacinaId());
            item.put("vacinaNome", v.getVacinaNome());
            item.put("dataAplicacao", v.getDataAplicacao());
            resultado.add(item);
        }

        return resultado;
    }

    // Salvar vacinação manualmente
    public Vacinacao salvar(Vacinacao vacinacao) {
        return vacinacaoRepository.save(vacinacao);
    }

    // Deletar vacinação
    public void deletar(String id) {
        vacinacaoRepository.deleteById(id);
    }

    /**
     * Gera automaticamente as vacinações com base nos dados do animal
     * buscado diretamente da coleção 'animals' do MongoDB.
     */
    public List<Vacinacao> gerarPorAnimal(String animalId) {
        // Busca o documento do animal diretamente da coleção 'animals'
        Query query = new Query(Criteria.where("_id").is(animalId));
        Document animalDoc = mongoTemplate.findOne(query, Document.class, "animals");

        if (animalDoc == null) {
            throw new NoSuchElementException("Animal não encontrado com ID: " + animalId);
        }

        String nomeAnimal = animalDoc.getString("nome");
        List<Document> vacinas = (List<Document>) animalDoc.get("vacinas");

        List<Vacinacao> vacinacoesGeradas = new ArrayList<>();

        if (vacinas == null || vacinas.isEmpty()) {
            return vacinacoesGeradas;
        }

        // Cria um documento de vacinação para cada vacina
        for (Document vacina : vacinas) {
            Vacinacao nova = new Vacinacao();
            nova.setAnimalId(animalId);
            nova.setAnimalNome(nomeAnimal);
            nova.setVacinaId(vacina.getObjectId("_id").toString());
            nova.setVacinaNome(vacina.getString("nome"));
            nova.setDataAplicacao(LocalDate.now());

            vacinacaoRepository.save(nova);
            vacinacoesGeradas.add(nova);
        }

        return vacinacoesGeradas;
    }
}
