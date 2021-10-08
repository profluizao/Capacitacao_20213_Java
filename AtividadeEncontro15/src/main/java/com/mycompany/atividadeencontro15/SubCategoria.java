package com.mycompany.atividadeencontro15;

public class SubCategoria extends CamposComuns implements IProjecaoDeDados {

    private int subCategoriaID;
    
    private int categoriaID;
    
    private Categoria categoria;
    
    private Produto produtos[];
    
    public Produto[] getProdutos(){
        return this.produtos;
    }
    
    public int getSubCategoriaID() {
        return subCategoriaID;
    }

    public void setSubCategoriaID(int subCategoriaID) {
        this.subCategoriaID = subCategoriaID;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public SubCategoria(Categoria novaCategoria){
        this.categoria = novaCategoria;
        this.categoriaID = categoria.getCategoriaID();
        this.produtos = new Produto[3];
    }
    
    public boolean AdicionarProduto(Produto produto){
        for (int i = 0; i < 3; i++) {
            if (this.produtos[i] == null ){
                this.produtos[i] = produto;
                return true;
            }
        }
        return false;
    }
    
    public void Imprimir(){
        System.out.println("\tSubCategoria ID:" +  this.subCategoriaID);
        System.out.println("\tCategoria ID:" +  this.categoriaID);
        System.out.println("\tDescrição: " + this.descricao);
        System.out.println("\tData de Inclusão:" + this.dataInsert);

        System.out.println("\tImprimir Produtos:");
        for (int i = 0; i < 3; i++) {
            this.produtos[i].Imprimir();
        }
        System.out.println("\t###########");
    }    
}
