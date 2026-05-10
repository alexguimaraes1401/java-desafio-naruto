package src.service;

import src.model.*;
import java.util.*;

public class ArenaService {
    private Map<String, Personagem> ninjas = new HashMap<>();

    public void mensagemInicial() {
        System.out.println("");
        System.out.println("# ARENA NINJA #");
        System.out.println("");
        System.out.println("Utilize os comandos abaixo para lutar:");
        this.listarComandos();
    }

    public void inicializarDados() {
        Jutsu rasengan = new Jutsu("Rasengan", 40, 20);

        NinjaDeNinjutsu naruto = new NinjaDeNinjutsu("Naruto", 17, "Folha");
        naruto.adicionarJutsu("Rasengan", rasengan);

        NinjaDeTaijutsu rocklee = new NinjaDeTaijutsu("RockLee", 17, "Folha");
        rocklee.adicionarJutsu("Lótus", new Jutsu("Lótus", 30, 10));

        ninjas.put(naruto.getNome().toLowerCase(), naruto);
        ninjas.put(rocklee.getNome().toLowerCase(), rocklee);
    }

    public void listarPersonagens() {
        System.out.println("\n--- Ninjas na Arena ---");
        ninjas.values().forEach(p -> p.exibirInformacoes());
    }

    public void listarComandos() {
        System.out.println("");
        System.out.println("- ajuda            -> Exibe a lista de comandos.");
        System.out.println("- listar           -> Exibe todos os Ninjas, Vida e Chakra.");
        System.out.println("- catalogo         -> Mostra os Jutsus permitidos no mundo.");
        System.out.println("- aprender [ninja] [jutsu] ");
        System.out.println("                    -> Ensina um Jutsu do catálogo ao Ninja.");
        System.out.println("- atacar [atacante] [jutsu] [alvo]");
        System.out.println("                    -> Realiza o ataque e calcula o dano/gasto.");
        System.out.println("- sair              -> Encerra a simulação.");
        System.out.println("");
    }

    public void ErroComando(String comando){
        System.out.println("O comando '" + comando + "' não foi identificado!");
        System.out.println("Use o comando 'ajuda' para listar os comandos existentes.");
    }

    public Personagem buscarNinja(String nome) {
        return ninjas.get(nome.toLowerCase());
    }

    public void ensinarJutsu(String nomeNinja, String nomeJutsu) {
        Personagem p = buscarNinja(nomeNinja);
        Jutsu jutsuMockado = JutsuCatalogo.buscar(nomeJutsu);

        if (p == null) {
            System.out.println("Erro: Ninja não encontrado.");
            return;
        }

        if (jutsuMockado != null) {
            p.adicionarJutsu(nomeJutsu, jutsuMockado);
            System.out.println(p.getNome() + " aprendeu " + jutsuMockado.getNome() + " com sucesso!");
        } else {
            System.out.println("Erro: O jutsu '" + nomeJutsu + "' não existe no catálogo oficial.");
        }
    }

    public void processarRegeneracao(String nomeAtacante) {
        int taxaRegeneracao = 10;

        ninjas.values().stream()
                .filter(n -> !n.getNome().equalsIgnoreCase(nomeAtacante))
                .forEach(n -> n.aumentarChakra(taxaRegeneracao));
    }

    public void verificarVencedor() {
        List<Personagem> vivos = ninjas.values().stream()
                .filter(n -> n.getVida() > 0)
                .toList();

        if (vivos.size() == 1) {
            System.out.println("\n========================================");
            System.out.println("   " + vivos.get(0).getNome().toUpperCase() + " venceu batalha!");
            System.out.println("========================================");
        }
    }
}