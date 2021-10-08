package com.mycompany.atividadeencontro15;

public class Categoria extends CamposComuns implements IProjecaoDeDados {
    
    private int categoriaID;
    
    private SubCategoria subCategorias[];

    public SubCategoria[] getSubCategorias(){
        return this.subCategorias;
    }
    
    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }
    
    public Categoria(){
        this.subCategorias = new SubCategoria[3];
    }
    
    public boolean AdicionarSubCategoria(SubCategoria subcat){
        for (int i = 0; i < 3; i++) {
            if (this.subCategorias[i] == null ){
                this.subCategorias[i] = subcat;
                return true;
            }
        }
        return false;
    }
    
    public void Imprimir(){
        System.out.println("Categoria ID:" +  this.categoriaID);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Data de Inclusão:" + this.dataInsert);

        System.out.println("Imprimir SubCategorias:");        
        for (int i = 0; i < 3; i++) {
            this.subCategorias[i].Imprimir();
        }
        System.out.println("--------------------------------------------");
    }
    
    public void imprimirRegistro(){
        System.out.println("Categoria ID:" +  this.categoriaID);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Data de Inclusão:" + this.dataInsert);
        System.out.println("--------------------------------------------");
    }
    
    public void imprimirSubCategorias(){
        System.out.println("\tImprimir SubCategorias:");        
        for (int i = 0; i < 3; i++) {
            this.subCategorias[i].Imprimir();
        }
        System.out.println("--------------------------------------------");
    }
}
