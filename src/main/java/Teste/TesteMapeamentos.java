package Teste;

import java.util.ArrayList;
import java.util.TreeSet;

import dao.AutorDAO;
import model.contatos.Telefone;
import model.locais.Instituicao;
import model.pessoas.Autor;

public class TesteMapeamentos {

	public static void main(String[] args) {
		/*
		 *  O teste deve mostrar que os métodos cadastrar, atualizar, excluir e listar
		 *  todos, das classes Autor, submissão de Artigo e submissão de Curso estão
		 *  funcionando
		 */
		Instituicao ifrs = new Instituicao();
		ifrs.setNome("IFRS - POA");
		ifrs.setEndereco("Coronel Vicente, xx");
		
		TreeSet<Autor> autores = new TreeSet<Autor>();
		// autor 1
			Autor autor1 = new Autor();
			Telefone telefone1 = new Telefone(53, 991999999L);
			
			ArrayList<String> emails1 = new ArrayList<String>();
			emails1.add("mf00@bol.com"); emails1.add("mf2@yahoo.com.br");
			
			autor1.setNome("Mariana Ferro");
			autor1.setTelefones(telefone1);
			autor1.setEmails(emails1);
			autor1.setInstituicao(ifrs);
		
		// autor 2
			Autor autor2 = new Autor();
			Telefone telefone2 = new Telefone(51, 998888888L);
			
			ArrayList<String> emails2 = new ArrayList<String>();
			emails2.add("b00@bol.com"); emails2.add("b2@yahoo.com.br");
			
			autor2.setNome("Be");
			autor2.setTelefones(telefone2);
			autor2.setEmails(emails2);
			autor2.setInstituicao(ifrs);
		
		autores.add(autor1);autores.add(autor2);
		ifrs.setAutores(autores);

		Instituicao ufrgs = new Instituicao();
		ufrgs.setNome("UFRGS");
		ufrgs.setEndereco("Av. Joao Pessoa, yy");
		
		// autor 3 
			Autor autor3 = new Autor();
			Telefone telefone3 = new Telefone(51, 993388888L);
			
			ArrayList<String> emails3 = new ArrayList<String>();
			emails3.add("llu00@bol.com"); emails3.add("llu3@yahoo.com.br");
			
			autor3.setNome("Lu");
			autor3.setTelefones(telefone3);
			autor3.setEmails(emails3);
			autor3.setInstituicao(ufrgs);
			
		TreeSet<Autor> autores2 = new TreeSet<Autor>();
		autores2 .add(autor3);
		ufrgs.setAutores(autores2);	
		
		AutorDAO ad = new AutorDAO();
		
		ad.insert(autor1);
		ad.insert(autor2);
		ad.insert(autor3);
		
	
	}

}
