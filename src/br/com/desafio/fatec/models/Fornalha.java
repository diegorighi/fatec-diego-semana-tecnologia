package br.com.desafio.fatec.models;

import br.com.desafio.fatec.interfaces.EquipamentoForno;
import br.com.desafio.fatec.interfaces.Ingrediente;

public class Fornalha implements EquipamentoForno {

	private static Fornalha instance;
	
	public static synchronized Fornalha getInstance() {
		if(instance == null)
			instance = new Fornalha();
		return instance;
	}
	
	@Override
	public Bolo assarUmBoloDe(Ingrediente elemento) {
		return new Bolo(elemento.getNomeBolo(), 
				elemento.getSaborBolo(),
				elemento.getPrecoBolo());
	}

}
