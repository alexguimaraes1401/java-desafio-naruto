package src.model;

public class Jutsu {
    private String nome;
    private int dano;
    private int consumoDeChakra;
    
    public Jutsu(String nome, int dano, int consumoDeChakra) {
        this.nome = nome;
        this.dano = dano;
        this.consumoDeChakra = consumoDeChakra;
    }

    public String getNome() { return nome; }
    public int getDano() { return dano; }
    public int getConsumoDeChakra() { return consumoDeChakra; }
}