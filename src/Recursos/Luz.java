package Recursos;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Luz extends Objeto implements Serializable{
	QualidadeLuz intensidade;
	QualidadeLuz cor;
	
	public Luz (QualidadeLuz intensidade, QualidadeLuz cor, String nome, int potencia, String comodo) {
		super(nome, potencia, comodo);
		this.intensidade = intensidade;
		this.cor = cor;
	}
	
	public QualidadeLuz getIntensidade() {
		return intensidade;
	}
	
	public void setIntensidade(QualidadeLuz intensidade) {
		this.intensidade = intensidade;
	}
	
	public QualidadeLuz getCor() {
		return cor;
	}
	
	public void setCor(QualidadeLuz cor) {
		this.cor = cor;
	}
	
	public String definirStatus() {
		if(super.isEstado()) {
			String out = "A luz esta acesa, com intensidade" +getIntensidade()+ "e cor atual" +getCor();
			return out;			
		}
		else {
			String out = "Luz apagada";
			return out;
		}
	}	
}
