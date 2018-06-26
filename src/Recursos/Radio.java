package Recursos;

public class Radio extends Objeto implements Serializable{
	public enum radioStation{		
		radio("Radio AM/FM"), cd("CD"), usb("USB");
		
		private String descricao;
		
		radioStation(String descricao){
			this.descricao = descricao;
		}
	}
	
	private int estacao;
	private int volume;
	
	public Radio(int estacao, int volume, String nome, int potencia, String comodo) {
		super(nome, potencia, comodo);
		this.volume = volume;
		this.estacao = estacao;
	}
	
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
	
	public String toString(){
		return definirStatus();
	}
	
	public String definirStatus(){
		String out = "O aparelho de som está ";
		if(isEstado())
			out += "ligado\n";
		else
			out += "desligado\n";
		out += "Estacao: " + this.estacao + " Volume: " + this.volume + "\n";
		return out;
	}
}
