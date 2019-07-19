package br.com.desafio.fatec.models;

import java.math.BigDecimal;

import br.com.desafio.fatec.enumerators.BolosEnum;
import br.com.desafio.fatec.interfaces.Ingrediente;

public class Cenoura implements Ingrediente {
	
	private static final String NOME_BOLO = BolosEnum.BOLO_DE_CENOURA_NOME.getValue();
	private static final String SABOR_BOLO = BolosEnum.BOLO_DE_CENOURA_SABOR.getValue();
	private static final BigDecimal PRECO_BOLO = new BigDecimal(5.70);

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
