package model.locais;

import java.io.Serializable;
import java.util.List;

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
	private String nome;
	
	private String endereco; 
    private List<Autor> autores;
	
	public Instituicao() { super(); }

	public Instituicao(String nome, String endereco, List<Autor> autores) {
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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	
	
}
