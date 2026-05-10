package src.model;

import java.util.HashMap;

import src.interfaces.Ninja;

public class NinjaDeTaijutsu extends Personagem implements Ninja {

    float taxaDesvio = 0.3f;

    public NinjaDeTaijutsu(String nome, int idade, String aldeia) {
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
        System.out.println(nome + " usa Taijutsu com golpes corpo a corpo!");
    }

    @Override
    public boolean desviar() {
        System.out.println(this.nome + " tenta desviar usando reflexos de Taijutsu...");
        boolean sucesso = Math.random() < this.taxaDesvio;
        if (sucesso) {
            System.out.println(this.nome + " desviou com técnica de Taijutsu!");
        }
        return sucesso;
    }

}
