package Recursos;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Cafeteira extends Objeto implements Serializable{
	EstadoCafeteira quantidade;
	private boolean acucar;
	EstadoCafeteira qtdLeite;
	
	public Cafeteira(EstadoCafeteira quantidade, EstadoCafeteira qtdLeite, boolean acucar, String nome, int potencia, String comodo) {
		super(nome, potencia, comodo);
		this.quantidade = quantidade;
		this.qtdLeite = qtdLeite;
		this.acucar = acucar;
	}
	
	public EstadoCafeteira getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(EstadoCafeteira quantidade) {
		this.quantidade = quantidade;
	}
	
	public boolean isAcucar() {
		return acucar;
	}
	
	public void setAcucar(boolean acucar) {
		this.acucar = acucar;
	}
	
	public EstadoCafeteira getQtdLeite() {
		return qtdLeite;
	}
	
	public void setQtdLeite(EstadoCafeteira qtdLeite) {
		this.qtdLeite = qtdLeite;
	}
	
	public String DefinirStatus() {
		if(super.getEstado() == true) {
			String out = "Café em preparo, com quantidade de cafe desejada:" +getQuantidade();
			out = out + "Quantidade de leite desejada: " +getQtdLeite();
			if(isAcucar()) {
				out = out + "Sim";				
			}
			else {
				out = out + "Nao";
			}
			return out;
		}
		else {
			String out = "Cafeteira desligada";
			return out;
		}		
	}	
}


