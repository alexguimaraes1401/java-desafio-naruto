package src.service;

import java.util.*;

import src.model.Jutsu;

public class JutsuCatalogo {
    private static final Map<String, Jutsu> biblioteca = new HashMap<>();

    static {
        biblioteca.put("rasengan", new Jutsu("Rasengan", 40, 20));
        biblioteca.put("chidori", new Jutsu("Chidori", 50, 25));
        biblioteca.put("katon", new Jutsu("Katon", 30, 10));
        biblioteca.put("lótus", new Jutsu("Lótus", 60, 30));
        biblioteca.put("amaterasu", new Jutsu("Amaterasu", 80, 50));
    }

    public static Jutsu buscar(String nome) {
        return biblioteca.get(nome.toLowerCase());
    }

    public static void listarCatalogo() {
        System.out.println("\n--- Jutsus Disponíveis ---");
        biblioteca.forEach((nome, j) -> 
            System.out.println("- " + j.getNome() + " (Dano: " + j.getDano() + " | Gasto: " + j.getConsumoDeChakra() + ")"));
    }
}
