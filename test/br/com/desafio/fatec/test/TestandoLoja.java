package br.com.desafio.fatec.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.desafio.fatec.models.Cenoura;
import br.com.desafio.fatec.models.Frango;
import br.com.desafio.fatec.models.Padaria;

public class TestandoLoja {

	@Test
	public void testaVendaBoloCenoura() {
		Padaria padaria = Padaria.getInstance();
		
		boolean fabricacaoBolo = padaria.venderBolo(new Cenoura());
		boolean vendaEfetivada = padaria.venderBolo(new Cenoura());
		
		assertFalse(fabricacaoBolo);
		assertTrue(vendaEfetivada);
		assertEquals(0, padaria.getListaBolos().size());
	}
	
	@Test
	public void testaVendaBoloFrango() {
		Padaria padaria = Padaria.getInstance();
		
		boolean fabricacaoBolo = padaria.venderBolo(new Frango());
		boolean vendaEfetivada = padaria.venderBolo(new Frango());
		
		assertFalse(fabricacaoBolo);
		assertTrue(vendaEfetivada);
		assertEquals(0, padaria.getListaBolos().size());
	}
}
