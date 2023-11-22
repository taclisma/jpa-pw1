package model.submissoes;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import model.pessoas.Autor;
import util.Situacao;

/**
 * Entity implementation class for Entity: Artigo
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "idArtigo", referencedColumnName = "idSubmissao")
public class Artigo extends Submissao implements Serializable {

	private static final long serialVersionUID = 1L;
	private String abstrato;
	private String resumo;
	
	
	public Artigo() { super(); }
	
	public Artigo(Long idSubmissao, String titulo, Date data, Set<Autor> autores, Situacao situacao, String abstrato,
			String resumo) {
		super(idSubmissao, titulo, data, autores, situacao);
		this.abstrato = abstrato;
		this.resumo = resumo;
	}

	public String getAbstrato() {
		return abstrato;
	}
	public void setAbstrato(String abstrato) {
		this.abstrato = abstrato;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t Artigo abstrato: \n\t" + abstrato + " \n\t resumo: \n\t" + resumo;
	}
	
	
   
}
