

import java.util.Scanner;

// Classe Jogo
public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introdução do Jogo
        System.out.println("##############################################################################\n");
        System.out.println("\tBem-vindos ao Jogo de Luta de One Piece!");
        System.out.println("\tZoro, o maior espadachim do mundo.  \n \tKisame, o melhor espadachim da névoa,\n \te Lufy o rei dos piratas.");
        System.out.println("\tCada personagem tem sua arma única e poder especial.");
        System.out.println("\tEscolha sabiamente suas ações durante a batalha para sair vitorioso!\n");
        System.out.println("##############################################################################\n");

        // Criação de instâncias de armas
        Arma espadaEnma = new Arma("Espada Enma", 40, 47, "Envenenamento");
        Arma samehada = new Arma("Samehada", 45, 60, "Congelamento");
        Arma Haki = new Arma("Haki", 55, 40, "Fogo");

        // Criação de instâncias de poderes
        Poder envenenamento = new PoderEnvenenamento();
        Poder congelamento = new PoderCongelamento();
        Poder Fogo = new Poder_Fogo();

        // Criação de instâncias de personagens
        Zoro zoro = new Zoro("Zoro", 100, espadaEnma, envenenamento);
        Kisame kisame = new Kisame("Kisame", 100, samehada, congelamento);
        Lufy lufy = new Lufy("Lufy", 100, Haki, Fogo);

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
        


        // Iniciar batalha chamando o método iniciar batalha
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
