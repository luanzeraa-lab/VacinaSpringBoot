package com.achamigos.achamigos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vacinas")
public class Vacina {

    @Id
    private String id;
    private String nome;


    private String validade;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getValidade() {return validade;}
    public void setValidade(String validade) {this.validade = validade;}
}