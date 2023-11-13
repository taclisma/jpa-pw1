package Teste;

import dao.AutorDAO;
import model.pessoas.Autor;

public class Teste1 {

	public static void main(String[] args) {
		Autor autor = new Autor();
		
		autor.setNome("Marcas");
		
		AutorDAO ad = new AutorDAO();
		
		ad.insert(autor);
	}

}
