/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jonathandamasiomedeiros
 */
// JPA tenta aproximar ao max o codigo cm o banco de dados
@Entity // define cm uma entidade
@Table (name = "atendimento") //vc é uma tabela com nome atendimento 

public class AtendimentoModel {
    // mapear a tabela
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nome", updatable = false)
    private String nome;
    
    @Column(updatable = false)
    private Date data;
    
    @Column(insertable = false) //nao precisa add no banco
    private Date atendimento;
    private int status; //0 = não atendido, 1 = senha em atendimento, 2 = já atendidos

    public AtendimentoModel(int id, String nome, Date data, Date atendimento, int status) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.atendimento = atendimento;
        this.status = status;
    }

    public AtendimentoModel(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Date atendimento) {
        this.atendimento = atendimento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
    
}
