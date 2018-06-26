package Recursos;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class AC extends Objeto implements Serializable {
	private int temperatura;
	private boolean ventilar;
	MinhaExcecao e = new MinhaExcecao("O valor eh incorreto!");
	
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura){
		this.temperatura = temperatura;
	}
	public boolean isVentilar() {
		return ventilar;
	}
	public void setVentilar(boolean ventilar) {
		this.ventilar = ventilar;
	}
	
	public AC(int temperatura, boolean ventilar, String nome, int potencia, String comodo) //ar condicionado de fabrica
	{
		super(nome, potencia, comodo);
		this.temperatura = temperatura;
		this.ventilar = ventilar;
	}
	
	public String toString()
	{
		return definirStatus();
	}
	
	public String definirStatus()
	{
		String out = "O ar condicionado está ";
		if(isEstado())
			out += "ligado\n";
		else
			out += "desligado\n";
		out += "Temperatura: " + this.temperatura;
		return out;
	}
	
}
