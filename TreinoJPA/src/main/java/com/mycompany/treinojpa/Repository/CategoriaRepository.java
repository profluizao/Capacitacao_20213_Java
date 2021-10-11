package com.mycompany.treinojpa.Repository;

import com.mycompany.treinojpa.Dominio.Categoria;
import java.util.List;
import javax.persistence.Query;

public class CategoriaRepository extends BaseRepository {
    

    public CategoriaRepository(String unitName){
        super(unitName);
    }
    
    public List<Categoria> browse(){
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
        Categoria nova = this.em.merge(categoria);
        this.Finalize();
        return nova;
        
    }
    
    public void add(Categoria categoria){
        this.em.persist(categoria);
        this.Finalize();
    }
    
    public void delete(Categoria categoria){
        this.em.remove(categoria);
        this.Finalize();
    }
}
