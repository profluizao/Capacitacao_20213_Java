package com.mycompany.treinojpa.Dominio;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CategoriaID")
    private int categoriaID;

    @Column(name = "Descricao")
    private String descricao;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name = "DataInsert")
    private Date dataInsert;    
    
    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInsert() {
        return dataInsert;
    }

    public void setDataInsert(Date dataInsert) {
        this.dataInsert = dataInsert;
    }
    
    public Categoria(){
    }

    public Categoria(int categoriaID, String descricao, Date dataInsert) {
        this.categoriaID = categoriaID;
        this.descricao = descricao;
        this.dataInsert = dataInsert;
    }

    @Override
    public String toString() {
        return "Categoria{" + "categoriaID=" + categoriaID + ", descricao=" + descricao + ", dataInsert=" + dataInsert + '}';
    }

}
