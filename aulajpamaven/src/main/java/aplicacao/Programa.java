package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		//inserir();
		//buscarPorId(4);
		removerPorId(6);
	}
	
	private static void removerPorId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa pessoa = em.find(Pessoa.class, id);
		
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();

		em.close();
		emf.close();

		System.out.println("Remoção realizada:");
		System.out.println(pessoa);
	}
	
	private static void buscarPorId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa pessoa = em.find(Pessoa.class, id);

		em.close();
		emf.close();
		
		System.out.println(pessoa);
	}
	
	
	private static void inserir() {
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println("Finalizado");		
	}

}
