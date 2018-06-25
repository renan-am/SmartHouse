package Recursos;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class AC extends Objeto implements Serializable{
	private int temperatura;
	private boolean ventilar;
	
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public boolean isVentilar() {
		return ventilar;
	}
	public void setVentilar(boolean ventilar) {
		this.ventilar = ventilar;
	}
	
	public AC() //ar condicionado de fabrica
	{
		super("Ar Condicionado", 1, "Nao foi adicionado a nenhum comodo");
		this.temperatura = 25;
		this.ventilar = false;
	}
	
	public String toString()
	{
		definirStatus();
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
