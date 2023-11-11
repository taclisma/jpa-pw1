package model.submissoes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import model.pessoas.Autor;

@Entity
public class Submissao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSubmissao;
	private String titulo;
	private Date data;
	private List<Autor> autores;
	
	
	public Submissao() {};
	public Submissao(String titulo, Date data) {
		super();
		this.titulo = titulo;
		this.data = data;
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
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	
	
	@Override
	public String toString() {
		return "Submissao [titulo=" + titulo + ", data=" + data + "]";
	}
	
	
	
	
	
}
