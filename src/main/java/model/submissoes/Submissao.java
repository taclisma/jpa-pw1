package model.submissoes;

import java.util.Date;


public class Submissao {
	String titulo;
	Date data;
	
	
	
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
	
	@Override
	public String toString() {
		return "Submissao [titulo=" + titulo + ", data=" + data + "]";
	}
	
	
	
	
	
	
	
}
