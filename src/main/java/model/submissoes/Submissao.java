package model.submissoes;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import model.pessoas.Autor;
import util.Situacao;

// como é um projeto pequeno e a classe Submissao não é abstrata, vou usar a solução que acho mais "correta"
@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Submissao implements Serializable, Comparable<Submissao> {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSubmissao")
	private Long idSubmissao;
	private String titulo;
	
	/* TODO 8.
	 *  Escolhi a submissão para ser a entidade dominante, pelos seguintes motivos:
	 * 		- O nome do sistema é um sistema de SUBMISSÃO, portanto essa parece ser a parte mais importante
	 */
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER) // TODO checar se ok so persist
	@JoinTable( name = "autor_de_submissao", 
			    joinColumns = { @JoinColumn(name= "idSubmissao") },
			    inverseJoinColumns = { @JoinColumn(name= "idAutor") } )
	private Set<Autor> autores;
	
	//TODO 5.
	@Temporal(TemporalType.DATE) // salva apenas o dia
	private Date data;
	//TODO 6.
	@Enumerated(EnumType.STRING) // salva a STRING do enum
	private Situacao situacao;
	
	
	public Submissao() {};

	
	public Submissao(String titulo, Date data, Set<Autor> autores, Situacao situacao) {
		super();
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
	
	@Override
	public String toString() {
		return "Submissao ID: " + idSubmissao + " \n\t titulo: " + titulo + " \n\t autores: " + autores
				+ " \n\t data: " + data + " \n\t situacao: " + situacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSubmissao, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Submissao other = (Submissao) obj;
		return Objects.equals(idSubmissao, other.idSubmissao) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public int compareTo(Submissao o) {
		return getTitulo().compareToIgnoreCase(o.getTitulo());
	}
}
