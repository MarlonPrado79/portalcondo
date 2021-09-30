package com.grupotema.portalcondo.domain.enums;

public enum NivelAcesso {

	GERAL(1, "Geral"),
	PROPRIETARIO(2, "Proprietário");
	
	private int cod;
	private String descricao;
	
	private NivelAcesso(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static NivelAcesso toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (NivelAcesso x : NivelAcesso.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
