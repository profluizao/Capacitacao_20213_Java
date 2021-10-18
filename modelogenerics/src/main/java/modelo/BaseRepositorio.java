package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseRepositorio<T>{

	private EntityManagerFactory factory;
	
	private EntityManager session;
	
	public BaseRepositorio(String nomeUnidade) {
		this.factory = Persistence.createEntityManagerFactory(nomeUnidade);
		this.session = this.factory.createEntityManager();
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public EntityManager getSession() {
		return session;
	}
}
