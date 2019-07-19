package br.com.desafio.fatec.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.fatec.interfaces.Caixa;
import br.com.desafio.fatec.interfaces.Ingrediente;

public class Padaria implements Caixa {
	
	private static Padaria instance;

	private List<Bolo> listaBolosDisponiveis = new ArrayList<Bolo>();
	private List<Bolo> listaBolosVendidos = new ArrayList<Bolo>();
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
			incluiBoloVendido(getBoloSelecionado());
			removeBoloDisponivel(getBoloSelecionado());
			addDinheiroCaixa(ingrediente.getPrecoBolo());
			sucesso = true;
		}
		else {
			Bolo bolo = fornalha.assar(ingrediente);
			incluiBoloDisponivel(bolo);
		}
		
		return sucesso;
	}
	
	private boolean verificaSeTemOBoloNaGeladeira(Ingrediente ingrediente) {
		boolean isBoloDisponivel = false;
		
		for(Bolo bolo : this.listaBolosDisponiveis) {
			if(bolo.getNomeBolo().equals(ingrediente.getNomeBolo())) {
				isBoloDisponivel = true;
				setBoloSelecionado(bolo);
			}
		}
		
		return isBoloDisponivel;
	}
	
	private void incluiBoloDisponivel(Bolo bolo) {
		this.listaBolosDisponiveis.add(bolo);
	}
	
	private void removeBoloDisponivel(Bolo bolo) {
		this.listaBolosDisponiveis.remove(bolo);
	}
	
	public List<Bolo> getListaBolosDisponiveis() {
		return this.listaBolosDisponiveis;
	}

	private Bolo getBoloSelecionado() {
		return this.boloSelecionado;
	}
	
	private void incluiBoloVendido(Bolo bolo) {
		this.listaBolosVendidos.add(bolo);
	}
	
	public List<Bolo> getListaBolosVendidos(){
		return this.listaBolosVendidos;
	}

	private void setBoloSelecionado(Bolo boloSelecionado) {
		this.boloSelecionado = boloSelecionado;
	}

	public BigDecimal getDinheiroCaixa() {
		return dinheiroCaixa;
	}

	public void addDinheiroCaixa(BigDecimal dinheiroCaixa) {
		this.dinheiroCaixa = this.dinheiroCaixa.add(dinheiroCaixa);
	}
	
	
	
}
