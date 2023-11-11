package model.contatos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Telefone
 *
 */
@Entity

public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;
	private int ddd;
	private Long numero;

	public Telefone() { super(); }

	public Telefone(int ddd, Long numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Telefone [ddd=" + ddd + ", numero=" + numero + "]";
	}
	
	
	
   
}
