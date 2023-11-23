package model.pessoas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
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

public class Autor implements Serializable, Comparable<Autor> {

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
	}
	
	

	@Override
	public String toString() {
		String aux = "";
		for (Submissao sub : submissoes) {
			aux += "" + sub.getTitulo() + "(" + sub.getData() + "), ";
		}
		return "\n\tAutor ID: " + idAutor + " \n\t Nome: " + nome + telefone.toString() + " \n\t Instituicao: "
				+ instituicao.getNome() + " \n\t Emails: " + emails + (aux.isBlank() ? "\n\t Sem submissoes" : "\n\t Submissoes: \n\t\t " + aux + ".");
	}
	
	@Override
	public int compareTo(Autor o) {
		return getNome().compareToIgnoreCase(o.getNome());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idAutor, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(idAutor, other.idAutor) && Objects.equals(nome, other.nome);
	}

	public boolean addSubmissoes(Submissao sub) {
		
		return this.submissoes.add(sub);
		
	};
	
   
}
