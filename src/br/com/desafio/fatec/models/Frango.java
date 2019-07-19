package br.com.desafio.fatec.models;

import java.math.BigDecimal;

import br.com.desafio.fatec.enumerators.BolosEnum;
import br.com.desafio.fatec.interfaces.Ingrediente;

public class Frango implements Ingrediente {

	private static final String NOME_BOLO = BolosEnum.BOLO_DE_FRANGO_NOME.getValue();
	private static final String SABOR_BOLO = BolosEnum.BOLO_DE_FRANGO_SABOR.getValue();
	private static final BigDecimal PRECO_BOLO = new BigDecimal(6.05);
	
	@Override
	public String getNomeBolo() {
		return NOME_BOLO;
	}

	@Override
	public String getSaborBolo() {
		return SABOR_BOLO;
	}

	@Override
	public BigDecimal getPrecoBolo() {
		return PRECO_BOLO;
	}

}
