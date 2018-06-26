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
	
	public TV(int canal, int brilho, int contraste, int volume, String nome, int potencia, String comodo) //padrao de fabrica
	{
		super(nome, potencia, comodo);
		this.canal = canal;
		this.brilho = brilho;
		this.contraste = contraste;
		this.volume = volume;
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
