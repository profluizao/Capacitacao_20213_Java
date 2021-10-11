package com.mycompany.treinojpa.Dominio;

import java.util.*;

public class SubCategoria {
    
    private int subCategoriaID;
    
    private int categoriaID;

    private String descricao;
    
    private Date dataInsert;

    public int getSubCategoriaID() {
        return subCategoriaID;
    }

    public void setSubCategoriaID(int subCategoriaID) {
        this.subCategoriaID = subCategoriaID;
    }

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

}
