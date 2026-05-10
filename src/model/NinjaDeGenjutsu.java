package src.model;

import java.util.HashMap;

import src.interfaces.Ninja;

public class NinjaDeGenjutsu extends Personagem implements Ninja {
    float taxaDesvio = 0.4f;

    public NinjaDeGenjutsu(String nome, int idade, String aldeia) {
        super(nome, idade, aldeia);
        this.jutsus = new HashMap<>();
        this.jutsus.put("KageBunshin", new Jutsu("Kage Bunshin", 30, 20));
        this.jutsus.put("Rasengan", new Jutsu("Rasengan", 50, 40));
    }

    @Override
    public float getTaxaDesvio() {
        return this.taxaDesvio * 100;
    }

    @Override
    public void usarJutsu() {
        System.out.println(nome + " conjura uma técnica ilusória de Genjutsu!");
    }

    @Override
    public boolean desviar() {
        System.out.println(this.nome + " tenta desviar confundindo o inimigo com Genjutsu...");
        boolean sucesso = Math.random() < this.taxaDesvio;
        if (sucesso) {
            System.out.println(this.nome + " desviou usando Genjutsu!");
        }
        return sucesso;
    }
}
