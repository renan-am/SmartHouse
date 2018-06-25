package Recursos;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Ventilador extends Objeto implements Serializable{
	EstadoVentilador intensidade;
	private boolean rotacao;
	
	public Ventilador(EstadoVentilador intensidade, boolean rotacao, String nome, int potencia, String comodo) {
		super(nome, potencia, comodo);
		this.intensidade = intensidade;
		this.rotacao = rotacao;
	}
	
	public EstadoVentilador getIntensidade() {
		return intensidade;
	}
	
	public void setIntensidade(EstadoVentilador intensidade) {
		this.intensidade = intensidade;
	}
	
	public boolean isRotacao() {
		return rotacao;
	}
	
	public void setRotacao(boolean rotacao) {
		this.rotacao = rotacao;
	}
	
	public String DefiniStatus() {
		if(super.getEstado() == true) {
			String out = "Ventilar ligado. Estado de rotacao: ";
			if(isRotacao())
				out = out + "Rotacionando.";
			else
				out = out + "Sem rotacao.";
			return out;
		}
		else {
			String out = "Ventilador desligado";
			return out;
		}
	}	
}
