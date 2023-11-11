package model.submissoes;

import java.io.Serializable;
import javax.persistence.*;
import model.submissoes.Submissao;

/**
 * Entity implementation class for Entity: Artigo
 *
 */
@Entity
public class Artigo extends Submissao implements Serializable {

	private static final long serialVersionUID = 1L;
	private String abstrato;
	private String resumo;
	
	
	public Artigo() { super(); }
	public Artigo(String abstrato, String resumo) {
		super();
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
	
	
   
}
