package util;

public enum Situacao {
	ENVIADA(1, "Enviada"),
	EM_ANALISE(2, "Em análise"),
	ACEITA(3, "Aceita"),
	REJEITADA(4, "Rejeitada");

	private final int valor;
	private final String descricao;

	private Situacao(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getValor() {
		return valor;
	}
	
	public String getItem() {
		return this.getValor() + " - " + this.getDescricao();
	}
	
}