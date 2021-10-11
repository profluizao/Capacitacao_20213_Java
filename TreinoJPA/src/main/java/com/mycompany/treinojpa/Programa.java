package com.mycompany.treinojpa;

import com.mycompany.treinojpa.Dominio.Categoria;
import com.mycompany.treinojpa.Repository.CategoriaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Programa {

    public static void main(String[] args) {
        
        CategoriaRepository repo = new CategoriaRepository("treinojpa");
        
        List<Categoria> cats = repo.browse();
        for (Categoria cat : cats) {
            System.out.println(cat);
        }
            
    }
    
    public static void listarCategorias(){

        System.out.println("-------------------------------------------------");
        System.out.println("Listando todas as categorias:");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("treinojpa");
        EntityManager em = emf.createEntityManager();
        
        Query qry = em.createQuery("FROM Categoria");
        
        List<Categoria> cats = qry.getResultList();
        
        em.close();
        emf.close();
        
        for (Categoria cat : cats) {
            System.out.println(cat);
        }
    }
    
    public static void obterPorID(int id){
        System.out.println("-------------------------------------------------");
        System.out.println("Listando apenas uma categoria (" + id + "):");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("treinojpa");
        EntityManager em = emf.createEntityManager();

        Categoria cat = em.find(Categoria.class, id);

        em.close();
        emf.close();
        
        System.out.println(cat);
    }
}
