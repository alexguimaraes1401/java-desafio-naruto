package src.model;

import java.util.Map;
import src.interfaces.Ninja;
import java.util.HashMap;

public abstract class Personagem {
    protected String nome;
    protected int idade;
    protected String aldeia;
    protected int chakra = 100;
    protected int vida = 100;
    protected Map<String, Jutsu> jutsus;

    public Personagem(String nome, int idade, String aldeia) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsus = new HashMap<>();
    }

    public abstract boolean desviar();
    public abstract float getTaxaDesvio();

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void adicionarJutsu(String nome, Jutsu jutsu) {
        this.jutsus.put(nome.toLowerCase(), jutsu);
    }

    public void exibirInformacoes() {
        System.out.println("NINJA: " + nome + " [" + this.getClass().getSimpleName() + "]");
        System.out.println("STATUS: Vida: " + vida + " | Chakra: " + chakra + " | Taxa de Desvio: " + (String.format("%.0f", getTaxaDesvio())) + "%");
        System.out.println("ALDEIA: " + aldeia);
        
        if (jutsus.isEmpty()) {
            System.out.println("JUTSUS: Nenhum jutsu aprendido ainda.");
        } else {
            System.out.print("JUTSUS: ");
            jutsus.forEach((nome, j) -> 
                System.out.print("[" + nome + " (Dano: " + j.getDano() + ", Gasto: " + j.getConsumoDeChakra() + ")] "));
        }
        System.out.println("\n----------------------------------------");
    }

    public void receberDano(int dano) {
        if (this.desviar()) {
            System.out.println(this.nome + " desviou com perfeição!");
        } else {
            this.vida -= dano;
            System.out.println(this.nome + " foi atingido! Vida restante: " + this.vida);
        }
    }

    public void usarJutsu(String nomeJutsu, Personagem alvo) {
        Jutsu jutsu = this.jutsus.get(nomeJutsu.toLowerCase());

        if (jutsu == null) {
            System.out.println("Erro: " + nome + " não conhece o jutsu " + nomeJutsu + "!");
            return;
        }

        if (this.chakra >= jutsu.getConsumoDeChakra()) {
            System.out.println(this.nome + " está usando " + nomeJutsu + "!");

            this.chakra -= jutsu.getConsumoDeChakra();

            alvo.receberDano(jutsu.getDano());
        } else {
            System.out.println(this.nome + " não tem chakra suficiente para o " + nomeJutsu + "!");
        }
    }

    public void aumentarChakra(int quantidade) {
        this.chakra = Math.min(100, this.chakra + quantidade);
        System.out.println(this.nome + " regenerou chakra! Atual: " + this.chakra);
    }
}