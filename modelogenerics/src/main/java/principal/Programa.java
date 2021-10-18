package principal;

import dominio.Categoria;
import servico.CategoriaServico;

public class Programa {

	public static void main(String[] args) {

		CategoriaServico servico = new CategoriaServico("capacitacao-jpa");
		
		for (Categoria item : servico.listar()) {
			System.out.println(item);
		}
		
		servico.dispose();

	}

}
