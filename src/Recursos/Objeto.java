package Recursos;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public abstract class Objeto implements Serializable{
	
	private String nome;
	private int potencia; // watt
	private String comodo;
	private boolean estado; // true(on) ou false(off)
	private LocalTime uso;
	Instant comecoTempoDeUso;
	private long tempoDeUso;
	
	public Objeto (String nome, int potencia, String comodo) {
		this.estado = false;
		this.nome = nome;
		this.potencia = potencia;
		this.comodo = comodo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getComodo() {
		return comodo;
	}

	public void setComodo(String comodo) {
		this.comodo = comodo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		// Verificar qual o estado que o objeto se encontra
		// Toda vez que ligar o objeto, gravamos o momento e o tempo de inicio
		if (this.estado == false && estado == true) {
			this.estado = estado;
			LocalTime horario = LocalTime.now();
			this.uso = horario;
			Instant inicio = Instant.now();
			this.comecoTempoDeUso = inicio;
		}
		// Toda vez que desligar o objeto, gravamos o tempo de fim
		else if (this.estado == true && estado == false) {
			this.estado = estado;
			Instant fim = Instant.now();
			Duration duracao = Duration.between(this.comecoTempoDeUso, fim);
			this.tempoDeUso = duracao.getSeconds();
		}
	}

	public LocalTime getUso() {
		return uso;
	}

	public long getTempoDeUso() {
		return tempoDeUso;
	}
	
	public double calcularConsumo() {
		return this.potencia*this.tempoDeUso*3.6; // watt/hora
	}
	
	public abstract String definirStatus();
	
}
