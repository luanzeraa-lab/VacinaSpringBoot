package com.achamigos.achamigos.repository;

import com.achamigos.achamigos.model.Vacinacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacinacaoRepository extends MongoRepository<Vacinacao, String> {}