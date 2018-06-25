
public class TV extends Objeto{
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
	
	public TV() //padrao de fabrica
	{
		super("Radio", 1, "Nao foi adicionado a nenhum comodo");
		this.canal = 0;
		this.brilho = 50;
		this.contraste = 50;
		this.volume = 50;
	}
	
	public String toString()
	{
		definirStatus();
	}
	
	public String definirStatus()
	{
		String out = "A tv está no canal  " + this.canal + "\n";
		out += "Brilho: " + this.brilho + " Contraste: " + this.contraste + " Volume: " + this.volume + "\n";
		return out;
	}
}
