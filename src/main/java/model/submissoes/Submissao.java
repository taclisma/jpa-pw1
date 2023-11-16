package model.submissoes;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import model.pessoas.Autor;
import util.Situacao;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // como é um projeto pequeno e a classe Submissao não é abstrata, vou usar a solução que acho mais "correta"
public class Submissao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSubmissao")
	private Long idSubmissao;
	private String titulo;
	
	/*
	 *  Escolhi a submissão para ser a entidade dominante, pelos seguintes motivos:
	 * 		- O nome do sistema é um sistema de SUBMISSÃO, portanto essa parece ser a parte mais importante
	 *		- 
	 * 
	 */
	
	@ManyToMany(cascade = CascadeType.PERSIST) // TODO checar se ok so persist
	@JoinTable( name = "autor_de_submissao", 
			    joinColumns = { @JoinColumn(name= "idSubmissao") },
			    inverseJoinColumns = { @JoinColumn(name= "idAutor") } )
	private Set<Autor> autores;
	
	@Temporal(TemporalType.DATE) // salva apenas o dia
	private Date data;
	
	@Enumerated(EnumType.STRING) // salva a STRING do enum
	private Situacao situacao;
	
	
	public Submissao() {};

	
	public Submissao(Long idSubmissao, String titulo, Date data, Set<Autor> autores, Situacao situacao) {
		super();
		this.idSubmissao = idSubmissao;
		this.titulo = titulo;
		this.data = data;
		this.autores = autores;
		this.setSituacao(situacao);
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Set<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public Long getIdSubmissao() {
		return idSubmissao;
	}
	public void setIdSubmissao(Long idSubmissao) {
		this.idSubmissao = idSubmissao;
	}
	public void addAutor(Autor autor) {
		this.autores.add(autor);
	}
	
	
	
	
}
