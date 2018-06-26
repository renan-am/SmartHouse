package Recursos;

import java.io.Serializable;

public class TV extends Objeto implements Serializable{
	private int canal;
	private int brilho;
	private int contraste;
	private int volume;
	public int getCanal() {
		return canal;
	}
	public void setCanal(int canal) {
		this.canal = canal;
	}
	public int getBrilho() {
		return brilho;
	}
	public void setBrilho(int brilho) {
		this.brilho = brilho;
	}
	public int getContraste() {
		return contraste;
	}
	public void setContraste(int contraste) {
		this.contraste = contraste;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public TV(String nome, int potencia, String comodo) //padrao de fabrica
	{
		super(nome, potencia, comodo);
		this.canal = 302;
		this.brilho = 50;
		this.contraste = 50;
		this.volume = 50;
	}
	
	public String toString()
	{
		return definirStatus();
	}
	
	public String definirStatus()
	{
		String out = "A TV esta ";
		if(isEstado()) {
			out += "ligada\n";
			out += "Canal " + this.canal + "\n";
			out += "Brilho: " + this.brilho + " Contraste: " + this.contraste + " Volume: " + this.volume + "\n";
		}
		else
			out += "desligada\n";
		return out;
	}
}
