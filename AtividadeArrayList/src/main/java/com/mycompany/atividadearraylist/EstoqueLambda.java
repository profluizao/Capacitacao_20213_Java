package com.mycompany.atividadearraylist;

import com.mycompany.atividadearraylist.FakeDB.*;
import java.util.*;

public class EstoqueLambda {
        private Scanner sc;

    public EstoqueLambda(){
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
            this.exibirProdutos(subcatid);
        }        
    }
    
    private void exibirCategorias(){
        System.out.println("As seguintes Categorias estão disponíveis:");
        System.out.println("------------------------------------------");
        
        EstoqueFakeDB.getCategorias()
                .stream()
                .filter(c -> (c.getCategoriaID() > 0) && (c.getCategoriaID() <= 3))
                .forEach(cat -> {
                    System.out.println("Categoria ID: " + cat.getCategoriaID());
                    System.out.println("Descrição: " + cat.getDescricao());
                    System.out.println("------------------------------------------");
                });
    }

    private void exibirSubCategorias(int catid){
        EstoqueFakeDB.getSubCategorias()
                .stream()
                .filter(sub -> sub.getCategoriaID() == catid)
                .forEach(subcat -> {
                    System.out.println("\tSubCategoria ID: " + subcat.getSubCategoriaID());
                    System.out.println("\tCategoria ID: " + subcat.getCategoriaID());
                    System.out.println("\tDescrição: " + subcat.getDescricao());
                    System.out.println("\t------------------------------------------");
                });
    }
    
    private void exibirProdutos(int subcatid){
        EstoqueFakeDB.getProdutos()
                .stream()
                .filter(pro -> pro.getSubCategoriaID() == subcatid)
                .forEach(prod -> {
                    System.out.println("\t\tProduto ID: " + prod.getProdutoID());
                    System.out.println("\t\tSubCategoria ID: " + prod.getSubCategoriaID());
                    System.out.println("\t\tCategoria ID: " + prod.getCategoriaID());
                    System.out.println("\t\tDescrição: " + prod.getDescricao());
                    System.out.println("\t\t------------------------------------------");
                });
    }    
}
