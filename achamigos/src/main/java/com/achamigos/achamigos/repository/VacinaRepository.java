/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.achamigos.achamigos.repository;
import com.achamigos.achamigos.model.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Alunos
 */
public interface VacinaRepository extends MongoRepository<Vacina, String> {
    Optional<Vacina> findByCodVacina(String codVacina);
    List<Vacina> findByAnimalId(String animalId);
}