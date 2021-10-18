package modelo;

import java.util.List;

public interface IGenericoServico<T> {

	void inserir(T instancia);
	
	void alterar(T instancia);
	
	void excluir(T instancia);
	
	void excluir(int id);
	
	List<T> listar();
	
	T obter(int id);	
}
