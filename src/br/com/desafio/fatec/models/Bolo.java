package br.com.desafio.fatec.models;

import java.math.BigDecimal;

public class Bolo {

	private String nomeBolo = null;
	private String saborBolo = null;
	private BigDecimal precoBolo = BigDecimal.ZERO;
	
	public Bolo(String nomeBolo, String saborBolo, BigDecimal precoBolo) {
		this.nomeBolo = nomeBolo;
		this.saborBolo = saborBolo;
		this.precoBolo = precoBolo;
	}

	public String getNomeBolo() {
		return nomeBolo;
	}

	public String getSaborBolo() {
		return saborBolo;
	}

	public BigDecimal getPrecoBolo() {
		return precoBolo;
	}
	
	
}
