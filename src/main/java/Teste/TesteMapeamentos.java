package Teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import dao.ArtigoDAO;
import dao.AutorDAO;
import dao.CursoDAO;
import dao.InstituicaoDAO;
import model.contatos.Telefone;
import model.locais.Instituicao;
import model.pessoas.Autor;
import model.submissoes.Artigo;
import model.submissoes.Curso;
import model.submissoes.Submissao;
import util.Situacao;

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
		Instituicao ufrgs = new Instituicao();
		ufrgs.setNome("UFRGS");
		ufrgs.setEndereco("Av. Joao Pessoa, yy");
		
		InstituicaoDAO iad = new InstituicaoDAO();
		iad.insert(ufrgs); iad.insert(ifrs);
		
		TreeSet<Autor> autores = new TreeSet<Autor>();
		// autor 1
			Telefone telefone1 = new Telefone(53, 991999999L);
			ArrayList<String> emails1 = new ArrayList<String>();
			emails1.add("mf00@bol.com"); emails1.add("mf2@ifrs.com.br");
			
			Autor autor1 = new Autor("Mariana Ferro", emails1, telefone1, ifrs);
		
		// autor 2
			Telefone telefone2 = new Telefone(51, 992888888L);			
			ArrayList<String> emails2 = new ArrayList<String>();
			emails2.add("b00@bol.com"); emails2.add("b2@ufrgs.com.br");

			Autor autor2 = new Autor("Be", emails2, telefone2, ufrgs);
		
		autores.add(autor1);autores.add(autor2);
		ifrs.setAutores(autores);

		
		// autor 3 
			Autor autor3 = new Autor();
			Telefone telefone3 = new Telefone(51, 993388888L);
			
			ArrayList<String> emails3 = new ArrayList<String>();
			emails3.add("llu00@bol.com"); emails3.add("llu3@ufrgs.com.br");
			
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
	
	// TODO listar todos, 
		List<Autor> listaAut = new ArrayList<Autor>();
		listaAut = ad.listAll();
		
		System.out.println(listaAut);
		
	//TODO update,
		Autor autorTeste = listaAut.get(0);
		Artigo artigo = new Artigo("Artigo JPA", new Date(), autores2, Situacao.EM_ANALISE, "Abstrato", "RESUMO");
		
		
	
		autorTeste.addSubmissoes(artigo);
		ad.update(autorTeste);
		
		
	// TODO delete,
		autorTeste = listaAut.get(1);
		if (ad.delete(autorTeste)) System.out.println("autor " + autorTeste.getNome() + " deletado do banco" );

		System.out.println(ad.listAll());
		System.out.println("Autor com id 3:" + ad.findByID(3L) );
		System.out.println("Autor com nome Mariana Ferro: \n" + ad.findByAttribute("Mariana Ferro") );
		
		
	// TODO teste submissoes
		ArtigoDAO artd = new ArtigoDAO();
		List<Artigo> listaArt = artd.listAll();
		System.out.println("Artigos: \n" + listaArt);
		

		Artigo artigoteste = listaArt.get(0); 
		artigoteste.setSituacao(Situacao.ACEITA);
		if (artd.update(artigoteste)) System.out.println("artigo " + artigoteste.getIdSubmissao() + " atualizado");
	
		autorTeste = ad.findByAttribute("Mariana Ferro").get(0);
		autores.clear();
		autores.add(autorTeste);
		
		Curso curso = new Curso("Curso 01", new Date(), autores, Situacao.ENVIADA, "Justificado", "Materiais", "Objeticos", 12.2);
		autorTeste.addSubmissoes(curso);

		CursoDAO cd = new CursoDAO();
		ad.update(autorTeste);
		
		System.out.println("Cursos: \n" + cd.listAll());
		curso = null;
		curso = cd.findByAttribute("Curso 01").get(0);
		curso.setSituacao(Situacao.REJEITADA);
		cd.update(curso);
		System.out.println(cd.findByID(2L));
		cd.delete(cd.findByAttribute("Curso 01").get(0));
		artd.delete(artd.findByID(1L));
		
		
		
	}
}
