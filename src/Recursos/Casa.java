package Recursos;

import java.io.Serializable;
import java.util.ArrayList;

public class Casa implements Serializable{
	private static Casa casa = new Casa("",null, 0, "");

	private String nome;
	private Estados estado;
	private int numComodos;
	ArrayList<String> comodos;
	ArrayList<Objeto> objetos;
	private String senha;


	public Casa (String nome, Estados estado, int numComodos, String senha) {
		this.nome = nome;
		this.estado = estado;
		this.numComodos = numComodos;
		this.senha = senha;
		
		comodos = new ArrayList<String>();
		objetos = new ArrayList<Objeto>();
	}

	public static Casa getInstance(){
	    return casa;
    }

    public static void setInstance(Casa nova){
         casa = nova;
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

    public void setComodos(ArrayList<String> comodos) {
        this.comodos = comodos;
    }

    public void setObjetos(ArrayList<Objeto> objetos) {
        this.objetos = objetos;
    }

    public ArrayList<String> getComodos() {
        return comodos;
    }

    public ArrayList<Objeto> getObjetos() {
        return objetos;
    }

    public double consumoTotal() {
		double parcial = 0;
		for (Objeto aux : objetos) {
			parcial = parcial + aux.calcularConsumo();
		}
		return parcial*estado.kWh;
	}
}
