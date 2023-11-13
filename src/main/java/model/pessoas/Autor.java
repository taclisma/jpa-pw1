package model.pessoas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;

import model.contatos.Telefone;
import model.locais.Instituicao;
import model.submissoes.Submissao;

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
	/*
	 * 	TODO: explicar /pesquisar  melhor
	 * 	Usando orphan removal aqui pois no caso de setar um novo telefone ou null, quero que o telefone anterior seja removido
	 */
	@OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "idTelefone")
	private Telefone telefone;
	
	@ManyToOne
	@JoinColumn( name= "idInstituicao" )
	private Instituicao instituicao;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "autor_tem_emails")
	private ArrayList<String> emails;

	@ManyToMany(mappedBy = "autores")
	private Set<Submissao> submissoes;
	
	public Autor() {};

	public Autor(String nome, ArrayList<String> emails, Telefone telefone, Instituicao instituicao) {
		super();
		this.nome = nome;
		this.emails = emails;
		this.telefone = telefone;
		this.instituicao = instituicao;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<String> getEmails() {
		return emails;
	}
	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}
	public Telefone getTelefones() {
		return telefone;
	}
	public void setTelefones(Telefone telefones) {
		this.telefone = telefones;
	}
	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	public Set<Submissao> getSubmissoes() {
		return submissoes;
	}
	public void setSubmissoes(Set<Submissao> submissoes) {
		this.submissoes = submissoes;
	}
	public Long getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	};
	
   
}
