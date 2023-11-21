package model.locais;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


import model.pessoas.Autor;

/**
 * Entity implementation class for Entity: Instituicao
 *
 */
@Entity

public class Instituicao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInstituicao;
	private String nome;
	
	private String endereco;
	
	@OneToMany (cascade = CascadeType.PERSIST) // TODO talvez cascaded tbm
	@JoinColumn(name = "idInstituicao")
    private Set<Autor> autores;
	
	public Instituicao() { super(); }

	public Instituicao(String nome, String endereco, Set<Autor> autores) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.autores = autores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idInstituicao, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instituicao other = (Instituicao) obj;
		return Objects.equals(idInstituicao, other.idInstituicao) && Objects.equals(nome, other.nome);
	}
	
}
