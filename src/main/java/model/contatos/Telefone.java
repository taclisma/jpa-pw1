package model.contatos;

import java.io.Serializable;
import java.util.Objects;

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
		return "Telefone: (" + ddd + ") " + numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, idTelefone, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return ddd == other.ddd && Objects.equals(idTelefone, other.idTelefone) && Objects.equals(numero, other.numero);
	}
	
	
   
}
