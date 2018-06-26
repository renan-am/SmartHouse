package Recursos;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Geladeira extends Objeto implements Serializable {
	private int qtdLatas;
	private int qtdGelo;
	private boolean aberta;
	
	public Geladeira(int qtdLatas, int qtdGelo, boolean aberta, String nome, int potencia, String comodo) {
		super(nome, potencia, comodo);
		this.qtdLatas = qtdLatas;
		this.qtdGelo = qtdGelo;
		this.aberta = aberta;
	}
	
	public int getQtdLatas() {		
		return qtdLatas;
	}
	
	public void setQtdLatas(int qtdLatas) {
		this.qtdLatas = qtdLatas;
	}
	
	public int getQtdGelo() {
		return qtdGelo;
	}
	
	public void setQtdGelo(int qtdGelo) {
		this.qtdGelo = qtdGelo;
	}
	
	public boolean isAberta() {
		return aberta;
	}
	
	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}
	
	public String definirStatus() {
		if(super.isEstado()) {
			String out = "Geladeira em funcionamento.\n";
			out = out + "Quantidade de latas armazenadas: " +getQtdLatas() +"\n";
			out = out + "Quantidade de gelo disponivel no momoento: " +getQtdGelo()+ "\n";
			return out;
		}
		else {
			String out = "Geladeira desligada.";
			return out;
		}
	}	
}
