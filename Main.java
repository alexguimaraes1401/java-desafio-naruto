import java.util.Scanner;

import src.model.Personagem;
import src.service.ArenaService;
import src.service.JutsuCatalogo;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArenaService arena = new ArenaService();

        arena.inicializarDados();

        arena.mensagemInicial();

        while (true) {
            System.out.print("\n> ");
            String[] comando = scanner.nextLine().split(" ");
            String acao = comando[0].toLowerCase();

            if (acao.equals("sair"))
                break;

            if (acao.equals("listar")) {
                arena.listarPersonagens();
            } 

            if (acao.equals("atacar") && comando.length == 4) {
                Personagem atacante = arena.buscarNinja(comando[1]);
                Personagem alvo = arena.buscarNinja(comando[3]);
                String jutsuNome = comando[2];

                if (atacante != null && alvo != null) {
                    atacante.usarJutsu(jutsuNome, alvo);
                    arena.processarRegeneracao(atacante.getNome());
                } else {
                    System.out.println("Ninja não encontrado!");
                }

            }

            if (acao.equals("aprender") && comando.length == 3) {
                arena.ensinarJutsu(comando[1], comando[2]);
            }
            
            if (acao.equals("catalogo")) {
                JutsuCatalogo.listarCatalogo();
            }

            if (acao.equals("ajuda")) {
                arena.listarComandos();
            } else {
                arena.ErroComando(acao);
            }
        }
    }
}