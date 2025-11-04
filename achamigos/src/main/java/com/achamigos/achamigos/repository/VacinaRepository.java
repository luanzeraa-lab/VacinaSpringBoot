package com.achamigos.achamigos.repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.achamigos.achamigos.model.Vacina;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    Optional<Vacina> findByNome(String nome);
}

