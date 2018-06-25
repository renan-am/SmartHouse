package Recursos;

public class Alarme extends Objeto{
	String horario;
	
	public Alarme() { //alarme padrao
		super("Alarme", 1, "Nao adicionado");
		this.horario = "12:00";
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
