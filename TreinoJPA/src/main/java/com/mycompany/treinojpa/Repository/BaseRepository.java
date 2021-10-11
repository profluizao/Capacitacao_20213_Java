package com.mycompany.treinojpa.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseRepository {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    
    public BaseRepository(String unitName){
        this.emf = Persistence.createEntityManagerFactory(unitName);
        this.em = this.emf.createEntityManager();
    }
    
    public void Finalize(){
        this.em.close();
        this.emf.close();
    }
}
