package Recursos;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Alarme extends Objeto implements Serializable{
	String horario;
	
	public Alarme(String horario, String nome, int potencia, String comodo) { //alarme padrao
		super(nome, potencia, comodo);
		this.horario = horario;
	}
	
	public String toString()
	{
		return definirStatus();
	}

	@Override
	public String definirStatus()
	{
		String out = "O alarme esta ";
		if(isEstado())
			out += "ligado\n";
		else
			out += "desligado\n";
		out += "Horario: " + this.horario;
		return out;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
