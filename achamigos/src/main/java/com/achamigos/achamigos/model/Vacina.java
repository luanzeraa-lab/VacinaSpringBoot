/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.achamigos.achamigos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 *
 * @author Alunos
 */
@Document(collection = "vacinas")
public class Vacina {
    
    @Id
    private String codVacina;
    private String idUsuario;
    private String nome;
    private String duracao;
    private String animalId;

    public String getCodVacina() {
        return codVacina;
    }

    public void setCodVacina(String codVacina) {
        this.codVacina = codVacina;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    
    
}
