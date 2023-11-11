package model.pessoas;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import model.contatos.Telefone;
import model.locais.Instituicao;

/**
 * Entity implementation class for Entity: Autor
 *
 */
@Entity

public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAutor;
	private String nome;
	private List<String> emails;
	private List<Telefone> telefones;
	private Instituicao instituicao;
	
	public Autor() {}

	public Autor(String nome, List<String> emails, List<Telefone> telefones, Instituicao instituicao) {
		super();
		this.nome = nome;
		this.emails = emails;
		this.telefones = telefones;
		this.instituicao = instituicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	};
	
	
   
}
