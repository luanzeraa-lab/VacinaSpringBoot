package com.achamigos.achamigos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vacinas")
public class Vacina {

    @Id
    private String id;
    private String codVacina;
    private String idUsuario;
    private String nome;
    private String duracao;
    private String animalId;

    public Vacina() {}

    public Vacina(String codVacina, String idUsuario, String nome, String duracao, String animalId) {
        this.codVacina = codVacina;
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.duracao = duracao;
        this.animalId = animalId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCodVacina() { return codVacina; }
    public void setCodVacina(String codVacina) { this.codVacina = codVacina; }

    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDuracao() { return duracao; }
    public void setDuracao(String duracao) { this.duracao = duracao; }

    public String getAnimalId() { return animalId; }
    public void setAnimalId(String animalId) { this.animalId = animalId; }
}
