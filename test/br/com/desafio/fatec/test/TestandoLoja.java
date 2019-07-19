package br.com.desafio.fatec.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.desafio.fatec.models.Bolo;
import br.com.desafio.fatec.models.Cenoura;
import br.com.desafio.fatec.models.Frango;
import br.com.desafio.fatec.models.Padaria;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestandoLoja {

	@Test
	public void testaPrimeiraVenda() {
		Padaria padaria = Padaria.getInstance();
		
		boolean fabricacaoBolo = padaria.venderBolo(new Cenoura());
		boolean vendaEfetivada = padaria.venderBolo(new Cenoura());
		
		assertFalse(fabricacaoBolo);
		assertTrue(vendaEfetivada);
		assertEquals(0, padaria.getListaBolosDisponiveis().size());
		assertEquals(1, padaria.getListaBolosVendidos().size());
	}
	
	@Test
	public void testaUltimaVenda() {
		Padaria padaria = Padaria.getInstance();
		
		boolean fabricacaoBolo = padaria.venderBolo(new Frango());
		boolean vendaEfetivada = padaria.venderBolo(new Frango());
		
		BigDecimal precoBolos = padaria.getListaBolosVendidos().stream()
				.map(Bolo::getPrecoBolo)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		assertFalse(fabricacaoBolo);
		assertTrue(vendaEfetivada);
		assertEquals(new BigDecimal(5.70).add(new BigDecimal(6.05)), precoBolos);
		assertEquals(0, padaria.getListaBolosDisponiveis().size());
		assertEquals(2, padaria.getListaBolosVendidos().size());
	}
	
}
