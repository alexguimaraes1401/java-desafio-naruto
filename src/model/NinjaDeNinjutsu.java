package src.model;

import java.util.*;

import src.interfaces.Ninja;

public class NinjaDeNinjutsu extends Personagem implements Ninja {

    float taxaDesvio = 0.6f;

    public NinjaDeNinjutsu(String nome, int idade, String aldeia) {
        super(nome, idade, aldeia);
        this.jutsus = new HashMap<>();
        this.jutsus.put("Kage Bunshin", new Jutsu("Kage Bunshin", 30, 20));
        this.jutsus.put("Rasengan", new Jutsu("Rasengan", 50, 40));
    }

    @Override
    public float getTaxaDesvio() {
        return this.taxaDesvio * 100;
    }

    @Override
    public void usarJutsu() {
        System.out.println(nome + " prepara um golpe físico!");
    }

    @Override
    public boolean desviar() {
        boolean sucesso = Math.random() < this.taxaDesvio;
        if (sucesso) {
            System.out.println(this.nome + " usou sua agilidade física para desviar!");
        }
        return sucesso;
    }

}
