package modelo;

import java.util.List;

public interface IGenericoRepositorio<T> {

	void create(T instancia);
	
	T read(int id);
	
	List<T> readAll();
	
	T update(T instancia);
	
	void delete(T instancia);
	
	void delete(int id);
	
}
