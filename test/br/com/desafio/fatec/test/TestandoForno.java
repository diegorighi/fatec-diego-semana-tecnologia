package br.com.desafio.fatec.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.desafio.fatec.models.Bolo;
import br.com.desafio.fatec.models.Cenoura;
import br.com.desafio.fatec.models.Fornalha;
import br.com.desafio.fatec.models.Frango;

public class TestandoForno {

	@Test
	public void assandoUmBoloDeCenoura() {
		Fornalha fornalha = Fornalha.getInstance();
		Bolo boloCenoura = fornalha.assar(new Cenoura());
		
		assertEquals("Bolo de cenoura", boloCenoura.getNomeBolo());
		assertEquals("Doce", boloCenoura.getSaborBolo());
		assertEquals(new BigDecimal(5.70), boloCenoura.getPrecoBolo());
	}
	
	@Test
	public void assandoUmBoloDeFrango() {
		Fornalha fornalha = Fornalha.getInstance();
		Bolo boloCenoura = fornalha.assar(new Frango());
		
		assertEquals("Bolo de frango", boloCenoura.getNomeBolo());
		assertEquals("Salgado", boloCenoura.getSaborBolo());
		assertEquals(new BigDecimal(6.05), boloCenoura.getPrecoBolo());
	}
}
