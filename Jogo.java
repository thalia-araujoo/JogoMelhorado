import java.util.Scanner;

// Classe Jogo
public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introdução do Jogo
        System.out.println("##############################################################################\n");
        System.out.println("\tBem-vindos ao Jogo de Luta entre Piratas!");
        System.out.println("\tZoro, o maior espadachim do mundo e \n \tKisame, o melhor espadachim da nevoa,\n \tLufy o rei dos piratas.");
        System.out.println("\tCada personagem tem sua arma única e poder especial.");
        System.out.println("\tEscolha sabiamente suas ações durante a batalha para sair vitorioso!\n");
        System.out.println("##############################################################################\n");

        // Criação de instâncias de armas
        Arma espadaEnma = new Arma("Espada Enma", 500, 80, null);
        Arma samehada = new Arma("Samehada", 300, 60, null);
        Arma balaDBorracha = new Arma("Bala De Borracha", 700, 100, "Endurecimento");

        // Criação de instâncias de poderes
        Poder envenenamento = new Poder("Envenenamento", 20, 40);
        Poder congelamento = new Poder("Congelamento", 30, 50);
        Poder endurecimento = new Poder("Endurecimento", 70, 90);

        // Criação de instâncias de personagens
        Zoro zoro = new Zoro("Zoro", 100, espadaEnma, envenenamento);
        Kisame kisame = new Kisame("Kisame", 100, samehada, congelamento);
        Lufy lufy = new Lufy("Lufy", 100, balaDBorracha, endurecimento);

        // Escolha do Personagem
        System.out.println("Escolha com qual personagem você deseja jogar:");
        System.out.println("1. Zoro");
        System.out.println("2. Kisame");
        System.out.println("3. Lufy");
        


        int escolhaPersonagem = scanner.nextInt();
        Personagem jogadorEscolhido = null;

        switch (escolhaPersonagem) {
            case 1:
                jogadorEscolhido = zoro;
                break;
            case 2:
                jogadorEscolhido = kisame;
                break;
            case 3:
                jogadorEscolhido = lufy;
                break;
            default:
                System.out.println("Escolha inválida. Encerrando o jogo.");
                System.exit(0);
        }

        // Exibir status inicial do personagem escolhido
        exibirStatusPersonagem(jogadorEscolhido);

        // Iniciar batalha
        Batalha batalha = new Batalha();
        batalha.iniciarBatalha(jogadorEscolhido, scanner);

        scanner.close();
    }

    public static void exibirStatusPersonagem(Personagem jogadorEscolhido) {
        System.out.println("----- Status de " + jogadorEscolhido.getNome() + " -----");
        System.out.println("Vida: " + jogadorEscolhido.getVida());
        System.out.println("Arma: " + jogadorEscolhido.getArma().getNome());
        if (jogadorEscolhido.getPoder() != null) {
            System.out.println("Poder: " + jogadorEscolhido.getPoder().getNome());
        }
        System.out.println("-----------------------------");
    }
}
