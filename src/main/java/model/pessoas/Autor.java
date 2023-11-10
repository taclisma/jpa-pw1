package model.pessoas;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Autor
 *
 */
@Entity

public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private List<String> emails;
	private List<Telefone> telefones;
	private Instituicao instituicao;
	
	public Autor() {};
   
}
