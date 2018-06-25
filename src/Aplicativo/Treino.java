package Aplicativo;

import java.io.Serializable;

public class Treino implements Serializable {
    private static Treino treino = new Treino();

    public String nome;
    public String local;
    public int comodos;

    public Treino(){
        nome = "";
        local = "";
        comodos = 0;
    }

    public static Treino getInstance(){
        return treino;
    }
}
