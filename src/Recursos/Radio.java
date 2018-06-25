
public class Radio extends Objeto 
{
	public enum radioStation{		
		radio("Radio AM/FM"), cd("CD"), usb("USB");
		
		private String descricao;
		
		radioStation(String descricao){
			this.descricao = descricao;
		}
	}
	
	private int estacao;
	private int volume;
	
	public int getEstacao() {
		return estacao;
	}
	public void setEstacao(int estacao) {
		this.estacao = estacao;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public String toString()
	{
		return definirStatus();
	}
	
	public String definirStatus()
	{
		String out = "O aparelho de som está ";
		if(this.estado)
			out += "ligado\n";
		else
			out += "desligado\n";
		out += "Estacao: " + this.estacao + " Volume: " + this.volume + "\n";
		return out;
	}
	
	public Radio()
	{
		super("Radio", 1, "Nao foi adicionado a nenhum comodo");
		this.volume = 50;
		this.estacao = 0;
	}
}
