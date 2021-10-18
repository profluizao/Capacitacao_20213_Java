package servico;

import java.util.List;

import dominio.Categoria;
import modelo.IGenericoServico;
import repositorio.CategoriaRepositorio;

public class CategoriaServico implements IGenericoServico<Categoria> {

	private CategoriaRepositorio repositorio;
	
	public CategoriaRepositorio getRepositorio() {
		return repositorio;
	}

	public CategoriaServico(String nomeUnidade) {
		this.repositorio = new CategoriaRepositorio(nomeUnidade);
	}
	
	@Override
	public void inserir(Categoria instancia) {
		this.repositorio.create(instancia);
		
	}

	@Override
	public void alterar(Categoria instancia) {
		this.repositorio.update(instancia);
	}

	@Override
	public void excluir(Categoria instancia) {
		this.repositorio.delete(instancia);
	}

	@Override
	public void excluir(int id) {
		this.repositorio.delete(id);
	}

	@Override
	public List<Categoria> listar() {
		return this.repositorio.readAll();
	}

	@Override
	public Categoria obter(int id) {
		return this.repositorio.read(id);
	}

	public void dispose() {
		this.repositorio.dispose();
	}
	
}
