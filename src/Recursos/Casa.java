package Recursos;

import java.io.Serializable;
import java.util.ArrayList;

public class Casa implements Serializable{
	
	private String nome;
	private Estados estado;
	private int numComodos;
	ArrayList<String> comodos;
	ArrayList<Objeto> objetos;
	private final String senha;
	
	public Casa (String nome, Estados estado, int numComodos, String senha) {
		this.nome = nome;
		this.estado = estado;
		this.numComodos = numComodos;
		this.senha = senha;
		
		comodos = new ArrayList<String>();
		objetos = new ArrayList<Objeto>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public int getNumComodos() {
		return numComodos;
	}

	public void setNumComodos(int numComodos) {
		this.numComodos = numComodos;
	}
	
	public double consumoTotal() {
		double parcial = 0;
		for (Objeto aux : objetos) {
			parcial = parcial + aux.calcularConsumo();
		}
		return parcial*estado.kWh;
	}
	
	public Objeto maisUtilizado() { //verifica qual eh o objeto mais utilizado
        Objeto maiorObjeto = objetos.get(0);
        Objeto objetoAtual;
        for (int i = 0; i < objetos.size(); i++) {
            objetoAtual = objetos.get(i);
            if(objetoAtual.getTempoDeUso() > maiorObjeto.getTempoDeUso())
                maiorObjeto = objetoAtual;
        }
        return maiorObjeto;
    }

	public ArrayList<String> getComodos() {
		return comodos;
	}

	public void setComodos(ArrayList<String> comodos) {
		this.comodos = comodos;
	}

	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}
	
	public void adicionarObjeto(Objeto obj)
    {
        this.objetos.add(obj);
    }
}
