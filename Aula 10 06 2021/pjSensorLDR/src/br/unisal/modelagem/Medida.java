package br.unisal.modelagem;

import java.util.GregorianCalendar;

public class Medida {
	private float luminosidade;
	private GregorianCalendar data;
	
	public Medida(){
		
	}

	public float getLuminosidade() {
		return luminosidade;
	}

	public void setLuminosidade(float luminosidade) {
		this.luminosidade = luminosidade;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}
}
