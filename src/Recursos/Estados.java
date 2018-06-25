
public enum Estados {
	BA(0.358f), SP(0.412f), AM(0.399f), RS(0.299f);
	
	public float kWh; // preço
	
	Estados(float valor) {
		kWh = valor;
	}
}
