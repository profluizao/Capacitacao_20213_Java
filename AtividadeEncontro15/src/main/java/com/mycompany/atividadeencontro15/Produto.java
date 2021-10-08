package com.mycompany.atividadeencontro15;

public class Produto extends CamposComuns implements IProjecaoDeDados {

    private int produtoID;
    
    private int categoriaID;
    
    private int subCategoriaID;
    
    private SubCategoria subCategoria;    
    
    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public int getSubCategoriaID() {
        return subCategoriaID;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Produto(SubCategoria novaSubCategoria){
        this.subCategoria = novaSubCategoria;
        this.subCategoriaID = this.subCategoria.getSubCategoriaID();
        this.categoriaID = this.subCategoria.getCategoria().getCategoriaID();
    }
    
    public void Imprimir(){
        System.out.println("\t\tProduto ID:" +  this.produtoID);
        System.out.println("\t\tSubCategoria ID:" +  this.subCategoriaID);
        System.out.println("\t\tCategoria ID:" +  this.categoriaID);
        System.out.println("\t\tDescrição: " + this.descricao);
        System.out.println("\t\tData de Inclusão:" + this.dataInsert);
        System.out.println("\t\t**********");
    }    
}
