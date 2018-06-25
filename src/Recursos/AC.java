
public class AC extends Objeto {
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
		if(this.estado)
			out += "ligado\n";
		else
			out += "desligado\n";
		out += "Temperatura: " + this.temperatura;
		return out;
	}
	
}
