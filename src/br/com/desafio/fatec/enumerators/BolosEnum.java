package br.com.desafio.fatec.enumerators;

public enum BolosEnum {

	BOLO_DE_CENOURA_NOME("Bolo de cenoura"),
	BOLO_DE_CENOURA_SABOR("Doce"),
	BOLO_DE_FRANGO_NOME("Bolo de frango"),
	BOLO_DE_FRANGO_SABOR("Salgado");
	
	private String elemento;
	
	BolosEnum(String elemento){
		this.elemento = elemento;
	}
	
	public String getValue() {
		return this.elemento;
	}
}
