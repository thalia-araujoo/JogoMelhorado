
import java.util.Scanner;

// Classe Batalha
class Batalha {
    public void iniciarBatalha(Personagem jogador, Scanner scanner) {
        System.out.println("Preparando-se para a batalha!\n");

        // Escolha do Oponente
        System.out.println("Escolha seu oponente:");
        System.out.println("1. Zoro");
        System.out.println("2. Kisame");
        System.out.println("3. Lufy");

        int escolhaOponente = scanner.nextInt();
        Personagem oponente = escolherOponente(escolhaOponente);

        exibirStatusPersonagem(oponente);

        System.out.println("\nVocê é o(a) " + jogador.getNome() + ". Seu oponente é o(a) " + oponente.getNome() + ".");
        System.out.println("\tQUE A BATALHA COMECE!\n");
        
        //Inicia um loop de batalha até que a vida de um dos personagens seja reduzida a zero.
        //Dentro do loop, o jogador escolhe entre "Atacar" ou "Usar Poder".
        //Realiza a ação escolhida, alternando entre o jogador e o oponente.

        while (jogador.getVida() > 0 && oponente.getVida() > 0) {
            System.out.println("Escolha sua ação, " + jogador.getNome() + "!");
            System.out.println("1. Atacar");
            System.out.println("2. Usar Poder");

            int escolhaAcao = scanner.nextInt();

            switch (escolhaAcao) {
                case 1:
                    realizarAtaque(jogador, oponente);
                    break;
                case 2:
                    jogador.usarPoder(oponente);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            Personagem temp = jogador;
            jogador = oponente;
            oponente = temp;

            exibirEstadoBatalha(jogador, oponente);
        }

        exibirResultadoBatalha(jogador, oponente);
    }

    public Personagem escolherOponente(int escolhaOponente) {
        switch (escolhaOponente) {
            case 1:
                return new Zoro("Zoro", 100, new Arma("Espada Enma", 40, 47, "Envenenamento"), new Poder("Envenenamento", escolhaOponente, escolhaOponente));
            case 2:
                return new Kisame("Kisame", 100, new Arma("Samehada", 45, 60, "Congelamento"), new Poder("Congelamento", escolhaOponente, escolhaOponente));
            case 3:
                return new Lufy("Lufy", 100, new Arma("Haki", 55, 40, "Fogo"), new Poder("Fogo", escolhaOponente, escolhaOponente));
            default:
                System.out.println("Escolha inválida. Encerrando o jogo.");
                System.exit(0);
                return null;
        }
    }

    //verifica a chance do atacante e do oponente de ganhar a batalha, sendo o calculo o mesmo para os dois, usando como principio.
    //a força e precisao.
    public void realizarAtaque(Personagem atacante, Personagem oponente) {
        Arma armaAtacante = atacante.getArma();
        Arma armaOponente = oponente.getArma();

        double chanceAcertoAtacante = (armaAtacante.getPrecisao() * 0.6) + (armaAtacante.getForca() * 0.4);
        double chanceAcertoOponente = (armaOponente.getPrecisao() * 0.6) + (armaOponente.getForca() * 0.4);

        if (chanceAcertoAtacante > chanceAcertoOponente) {
            System.out.println("O ataque com a " + armaAtacante.getNome() + " é bem-sucedido! " +
                    atacante.getNome() + " ganha a jogada!");

            if (armaAtacante.getEfeitoEspecial() != null) {
                System.out.println("Efeito especial da arma: " + armaAtacante.getEfeitoEspecial());
            }

            int dano = calcularDano(armaAtacante);
            oponente.sofrerDano(dano);

            System.out.println("Dano causado: " + dano);
        } else if (chanceAcertoAtacante < chanceAcertoOponente) {
            System.out.println("O ataque com a " + armaOponente.getNome() + " é bem-sucedido! " +
                    oponente.getNome() + " ganha a jogada!");

            if (armaOponente.getEfeitoEspecial() != null) {
                System.out.println("Efeito especial da arma: " + armaOponente.getEfeitoEspecial());
            }

            int dano = calcularDano(armaOponente);
            atacante.sofrerDano(dano);

            System.out.println("Dano causado: " + dano);
        } else {
            System.out.println("Ambos os ataques falharam!");
        }
    }

    public int calcularDano(Arma arma) {
        return arma.getForca() + arma.getPrecisao();
    }

    //metodo para exibir o estado da batalha
    public void exibirEstadoBatalha(Personagem jogador1, Personagem jogador2) {
        System.out.println("----- Estado da Batalha -----");
        System.out.println(jogador1.getNome() + ": Vida - " + jogador1.getVida());
        System.out.println(jogador2.getNome() + ": Vida - " + jogador2.getVida());
        System.out.println("-----------------------------");
    }

    //metodo para exibir o resultado da batalha
    public void exibirResultadoBatalha(Personagem jogador1, Personagem jogador2) {
        System.out.println("----- Resultado da Batalha -----");
        if (jogador1.getVida() > 0) {
            System.out.println(jogador1.getNome() + " venceu!\n");
            System.out.println("Fim da Batalha!");
        } else if (jogador2.getVida() > 0) {
            System.out.println(jogador2.getNome() + " venceu!\n");
            System.out.println("Fim da Batalha!");
        } else {
            System.out.println("Empate!");
        }
        System.out.println("-------------------------------");
    }

    public static void exibirStatusPersonagem(Personagem jogadorOponente) {
        System.out.println("----- Status de " + jogadorOponente.getNome() + " -----");
        System.out.println("Vida: " + jogadorOponente.getVida());
        System.out.println("Arma: " + jogadorOponente.getArma().getNome());
        if (jogadorOponente.getPoder() != null) {
            System.out.println("Poder: " + jogadorOponente.getPoder().getNome());
        }
        System.out.println("-----------------------------");
    }
}
