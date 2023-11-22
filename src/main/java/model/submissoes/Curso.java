package model.submissoes;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import model.pessoas.Autor;
import util.Situacao;

/**
 * Entity implementation class for Entity: Curso
 *
 */
/**
 * 
 */
@Entity
@PrimaryKeyJoinColumn(name = "idCurso", referencedColumnName = "idSubmissao")
public class Curso extends Submissao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String justificativa;
	private String material;
	private String objetivo;
	private double duracao;
	
	
	public Curso() { super(); }
	
	

	public Curso(Long idSubmissao, String titulo, Date data, Set<Autor> autores, Situacao situacao,
			String justificativa, String material, String objetivo, double duracao) {
		super(idSubmissao, titulo, data, autores, situacao);
		this.justificativa = justificativa;
		this.material = material;
		this.objetivo = objetivo;
		this.duracao = duracao;
	}


	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public double getDuracao() {
		return duracao;
	}
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}



	@Override
	public String toString() {
		return super.toString() + "\n\t Curso justificativa: \n\t" + justificativa + " \n\t material: " + material + " \n\t objetivo: " + objetivo
				+ " \n\t duracao: " + duracao;
	}
	
	
   
}
