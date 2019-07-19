package br.com.desafio.fatec.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.fatec.interfaces.Caixa;
import br.com.desafio.fatec.interfaces.Ingrediente;

public class Padaria implements Caixa {
	
	private static Padaria instance;

	private List<Bolo> listaBolos = new ArrayList<Bolo>();
	private BigDecimal dinheiroCaixa = BigDecimal.ZERO;
	private Fornalha fornalha = Fornalha.getInstance();
	private Bolo boloSelecionado = null;
	
	public static synchronized Padaria getInstance() {
		if(instance == null)
			instance = new Padaria();
		return instance;
	}
	
	@Override
	public boolean venderBolo(Ingrediente ingrediente) {
		boolean sucesso = false;
		
		if(verificaSeTemOBoloNaGeladeira(ingrediente)) {
			removeBolo(getBoloSelecionado());
			setDinheiroCaixa(ingrediente.getPrecoBolo());
			sucesso = true;
		}
		else {
			Bolo bolo = fornalha.assar(ingrediente);
			adicionaBolo(bolo);
		}
		
		return sucesso;
	}
	
	private boolean verificaSeTemOBoloNaGeladeira(Ingrediente ingrediente) {
		boolean isBoloDisponivel = false;
		
		for(Bolo bolo : this.listaBolos) {
			if(bolo.getNomeBolo().equals(ingrediente.getNomeBolo())) {
				isBoloDisponivel = true;
				setBoloSelecionado(bolo);
			}
		}
		
		return isBoloDisponivel;
	}
	
	private void adicionaBolo(Bolo bolo) {
		this.listaBolos.add(bolo);
	}
	
	private void removeBolo(Bolo bolo) {
		this.listaBolos.remove(bolo);
	}
	
	public List<Bolo> getListaBolos() {
		return this.listaBolos;
	}

	private Bolo getBoloSelecionado() {
		return this.boloSelecionado;
	}

	private void setBoloSelecionado(Bolo boloSelecionado) {
		this.boloSelecionado = boloSelecionado;
	}

	public BigDecimal getDinheiroCaixa() {
		return dinheiroCaixa;
	}

	public void setDinheiroCaixa(BigDecimal dinheiroCaixa) {
		this.dinheiroCaixa.add(dinheiroCaixa);
	}
	
	
	
}
