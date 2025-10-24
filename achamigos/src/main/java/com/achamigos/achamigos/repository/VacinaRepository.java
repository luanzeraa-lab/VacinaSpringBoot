package com.achamigos.achamigos.repository;

import com.achamigos.achamigos.model.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    Optional<Vacina> findByCodVacina(String codVacina);
    List<Vacina> findByAnimalId(String animalId);
}
