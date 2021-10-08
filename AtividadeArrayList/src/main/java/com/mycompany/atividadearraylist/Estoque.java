package com.mycompany.atividadearraylist;

import java.util.*;
import com.mycompany.atividadearraylist.FakeDB.*;
import com.mycompany.atividadearraylist.Pojo.*;

public class Estoque {

    private Scanner sc;

    public Estoque(){
        this.sc = new Scanner(System.in);
        EstoqueFakeDB.getCategorias();
        EstoqueFakeDB.getSubCategorias();
        EstoqueFakeDB.getProdutos();
    }
    
    public void testarExibicao(){
        this.exibirCategorias();
        System.out.println("Selecione a Categoria (ID) para exibir as SubCategorias disponíveis:");
        int catid = this.sc.nextInt();
        if ((catid != 1) && (catid != 2) && (catid != 3)){
            System.out.println("\tA Categoria selecionada não está disponível.");
        }
        else{
            this.exibirSubCategorias(catid);
            System.out.println("\t\tSelecione a SubCategoria (ID) para exibir os produtos disponíveis:");
            int subcatid = this.sc.nextInt();
            boolean achei = this.exibirProdutos(subcatid);
            if (achei == false){
                System.out.println("Não existem produtos disponíveis para essa SubCategoria.");
            }
        }
    }
    
    private void exibirCategorias(){
        System.out.println("As seguintes Categorias estão disponíveis:");
        System.out.println("------------------------------------------");
        for (int i = 0; i < 3; i++) {
            CategoriaPojo ca = EstoqueFakeDB.getCategorias().get(i);
            System.out.println("Categoria ID: " + ca.getCategoriaID());
            System.out.println("Descrição: " + ca.getDescricao());
            System.out.println("------------------------------------------");
        }
    }
    
    private void exibirSubCategorias(int catid){
        for (SubCategoriaPojo subCat : EstoqueFakeDB.getSubCategorias()) {
            if (subCat.getCategoriaID() == catid){
                System.out.println("\tSubCategoria ID: " + subCat.getSubCategoriaID());
                System.out.println("\tCategoria ID: " + subCat.getCategoriaID());
                System.out.println("\tDescrição: " + subCat.getDescricao());
                System.out.println("\t------------------------------------------");
            }
        }
    }
    
    private boolean exibirProdutos(int subcatid){
        boolean achei = false;
        for (ProdutoPojo prod : EstoqueFakeDB.getProdutos()) {
            if (prod.getSubCategoriaID() == subcatid){
                System.out.println("\t\tProduto ID: " + prod.getProdutoID());
                System.out.println("\t\tSubCategoria ID: " + prod.getSubCategoriaID());
                System.out.println("\t\tCategoria ID: " + prod.getCategoriaID());
                System.out.println("\t\tDescrição: " + prod.getDescricao());
                System.out.println("\t\t------------------------------------------");
                achei = true;
            }
        }
        return achei;
    }
}
