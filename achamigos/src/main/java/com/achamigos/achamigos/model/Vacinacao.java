package com.achamigos.achamigos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "vacinacao")

public class Vacinacao {

    @Id
    private String id;
    private String animalId;
    private String vacinaId;
    private LocalDate dataAplicacao;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAnimalId() { return animalId; }
    public void setAnimalId(String animalId) { this.animalId = animalId; }

    public String getVacinaId() { return vacinaId; }
    public void setVacinaId(String vacinaId) { this.vacinaId = vacinaId; }

    public LocalDate getDataAplicacao() { return dataAplicacao; }
    public void setDataAplicacao(LocalDate dataAplicacao) { this.dataAplicacao = dataAplicacao; }
}