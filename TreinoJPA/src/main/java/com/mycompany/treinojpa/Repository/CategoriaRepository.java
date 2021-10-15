package com.mycompany.treinojpa.Repository;

import com.mycompany.treinojpa.Dominio.Categoria;
import java.util.List;
import javax.persistence.Query;

public class CategoriaRepository extends BaseRepository {
    

    public CategoriaRepository(String unitName){
        super(unitName);
    }
    
    public List<Categoria> browse(){
        @SuppressWarnings("JPQLValidation")
        Query qry = this.em.createQuery("FROM Categoria");
        List<Categoria> cats = qry.getResultList();
        this.Finalize();
        return cats;
    }
    
    public Categoria read(int id){
        Categoria cat = this.em.find(Categoria.class, id);
        this.Finalize();
        return cat;        
    }
    
    public Categoria edit(Categoria categoria){
        Categoria cat = this.em.find(Categoria.class, categoria.getCategoriaID());
        this.em.detach(cat);
        this.em.getTransaction().begin();
        Categoria mergeCategoria = (Categoria)this.em.merge(cat);
        this.em.getTransaction().commit();
        this.Finalize();
        return mergeCategoria;
        
    }
    
    public void add(Categoria categoria){
        this.em.getTransaction().begin();
        this.em.persist(categoria);
        this.em.getTransaction().commit();
        this.Finalize();
    }
    
    public void delete(Categoria categoria){
        this.em.getTransaction().begin();
        this.em.remove(categoria);
        this.em.getTransaction().commit();
        this.Finalize();
    }
}
