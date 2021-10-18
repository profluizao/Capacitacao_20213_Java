package repositorio;

import java.util.List;

import javax.persistence.Query;

import dominio.Categoria;
import modelo.BaseRepositorio;
import modelo.IGenericoRepositorio;

public class CategoriaRepositorio 
	extends BaseRepositorio<Categoria> 
	implements IGenericoRepositorio<Categoria> {

	public CategoriaRepositorio(String nomeUnidade) {
		super(nomeUnidade);
	}

	@Override
	public void create(Categoria instancia) {
		this.getSession().getTransaction().begin();
		this.getSession().persist(instancia);
		this.getSession().getTransaction().commit();
	}

	@Override
	public Categoria read(int id) {
		Categoria cat = this.getSession().find(Categoria.class, id);
		return cat;
	}

	@Override
	public List<Categoria> readAll() {
		Query qry = this.getSession().createQuery("FROM Categoria");
		@SuppressWarnings("unchecked")
		List<Categoria> lista = qry.getResultList();
		return lista;
	}

	@Override
	public Categoria update(Categoria instancia) {
		Categoria cat = this.getSession().find(Categoria.class, instancia.getCategoriaId());
		this.getSession().detach(cat);
		this.getSession().getTransaction().begin();
		Categoria mergeCategoria = (Categoria)this.getSession().merge(instancia);
		this.getSession().getTransaction().commit();
		return mergeCategoria;
	}

	@Override
	public void delete(Categoria instancia) {
		Categoria cat = this.getSession().find(Categoria.class, instancia.getCategoriaId());
		this.getSession().getTransaction().begin();
		this.getSession().remove(cat);
		this.getSession().getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		Categoria cat = this.getSession().find(Categoria.class, id);
		this.getSession().getTransaction().begin();
		this.getSession().remove(cat);
		this.getSession().getTransaction().commit();
	}

	public void dispose() {
		this.getSession().close();
		this.getFactory().close();
	}
}
