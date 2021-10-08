package com.mycompany.atividadeencontro15;

import java.util.Scanner;
import java.util.Date;

public class Estoque {

    private Scanner sc;
    
    private Categoria categorias[];
    
    public Estoque(){
        this.sc = new Scanner(System.in);        
    }
    
    //Modelo Simples.
    public void Testar(){
        Date dataDeInsercao = new Date(System.currentTimeMillis());
        
        Categoria cat = new Categoria();
        cat.setCategoriaID(1);
        cat.setDescricao("Categoria Teste");
        cat.setDataInsert(dataDeInsercao);
        
        SubCategoria subcat = new SubCategoria(cat);
        subcat.setSubCategoriaID(1);
        subcat.setDescricao("SubCategoria Outro Teste");
        subcat.setDataInsert(dataDeInsercao);
        
        Produto pro = new Produto(subcat);
        pro.setProdutoID(1);
        pro.setDescricao("Produto Novo");
        pro.setDataInsert(dataDeInsercao);

        Pais pais = new Pais();
        pais.setPaisID(1);
        pais.setAbreviacao("EUA");

        Funcionario fun = new Funcionario(pais);
        fun.setFuncionarioID(1);
        fun.setChave(123456798);
        
    }
    
    //Modelo Intermediário.
    public void testarComVetores(){
        this.inicializarVetorCategorias();
        this.imprimirTudo(categorias);
        this.sc.nextLine();
    }
    
    public void testarComSelecao(){
        this.inicializarVetorCategorias();
        System.out.println("Qual categoria deseja exibir os detalhes:");
        int id = this.sc.nextInt();
        this.exibirCategoria(id);
        System.out.println("Finalizado");
        this.sc.nextLine();
    } 
    
    private void exibirCategoria(int id){
        boolean enc = false;
        for (int i = 0; i < 3; i++) {
            if (id == this.categorias[i].getCategoriaID()){
                this.categorias[i].imprimirRegistro();
                this.exibirRestante(i);
                enc = true;
            }
        }
        if (enc == false){
            System.out.println("ID não encontrado.");
        }
    }
    
    private void exibirRestante(int posicao){
        System.out.println("Deseja exibir o restante?");
        char op = this.sc.next().charAt(0);
        if (op == 'S'){
            this.categorias[posicao].imprimirSubCategorias();
        }
    }
    
    private void inicializarVetorCategorias(){
        Date dataDeInsercao = new Date(System.currentTimeMillis());
        this.categorias = new Categoria[3]; 
        categorias[0] = this.criarCategoria(1, "Teste 1", dataDeInsercao);
        categorias[1] = this.criarCategoria(2, "Teste 2", dataDeInsercao);
        categorias[2] = this.criarCategoria(3, "Teste 3", dataDeInsercao);
    }
    
    private Categoria criarCategoria(int id, String descricao, Date dataDeInsert){
        Categoria cat = new Categoria();
        cat.setCategoriaID(id);
        cat.setDescricao(descricao);
        cat.setDataInsert(dataDeInsert);
        for (int i = 0; i < 3; i++) {
            int j = i + 1;
            SubCategoria s = this.criarSubCategoria(cat, j, "Teste SubCategoria " + j, dataDeInsert);
            cat.AdicionarSubCategoria(s);
        }
        return cat;
    }
    
    private SubCategoria criarSubCategoria(Categoria cat, int id, String descricao, Date dataDeInsert){
        SubCategoria sub = new SubCategoria(cat);
        sub.setSubCategoriaID(id);
        sub.setDescricao(descricao);
        sub.setDataInsert(dataDeInsert);
        for (int i = 0; i < 3; i++) {
            int j = i + 1;
            Produto p = this.criarProduto(sub, j, "Teste Produto " + j, dataDeInsert);
            sub.AdicionarProduto(p);
        }
        return sub;
    }
    
    private Produto criarProduto(SubCategoria sub, int id, String descricao, Date dataDeInsert){
        Produto pro = new Produto(sub);
        pro.setProdutoID(id);
        pro.setDescricao(descricao);
        pro.setDataInsert(dataDeInsert);
        return pro;
    }
    
    private void imprimirTudo(Categoria categoria[]){
        System.out.println("Imprimindo Categorias:");
        for (int i = 0; i < 3; i++) {
            categoria[i].Imprimir();
        }        
    }
}
