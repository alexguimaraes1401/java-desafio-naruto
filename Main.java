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
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                continue;
            }

            String[] comando = entrada.split("\\s+");
            String acao = comando[0].toLowerCase();

            switch (acao) {
                case "sair":
                    scanner.close();
                    return;

                case "listar":
                    arena.listarPersonagens();
                    break;

                case "atacar":
                    if (comando.length != 4) {
                        System.out.println("Uso correto: atacar [atacante] [jutsu] [alvo]");
                        break;
                    }

                    Personagem atacante = arena.buscarNinja(comando[1]);
                    Personagem alvo = arena.buscarNinja(comando[3]);
                    String jutsuNome = comando[2];

                    if (atacante != null && alvo != null) {
                        atacante.usarJutsu(jutsuNome, alvo);
                        arena.processarRegeneracao(atacante.getNome());
                        arena.verificarVencedor();
                    } else {
                        System.out.println("Ninja não encontrado!");
                    }
                    break;

                case "aprender":
                    if (comando.length != 3) {
                        System.out.println("Uso correto: aprender [ninja] [jutsu]");
                        break;
                    }
                    arena.ensinarJutsu(comando[1], comando[2]);
                    break;

                case "catalogo":
                    JutsuCatalogo.listarCatalogo();
                    break;

                case "ajuda":
                    arena.listarComandos();
                    break;

                default:
                    arena.ErroComando(acao);
                    break;
            }
        }
    }
}