package jogo;

import personagem.Npc;
import personagem.Personagem;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Jogo {

    private NivelDificuldade dificuldade;
    Random random = new Random();

    public boolean combate(Personagem jogador, Npc npc, boolean isTurnoJogador) {
        boolean lutando = true, venceu = false, turnoDoJogador = isTurnoJogador;
        String frasePadrao = "", acao;
        Double dano;

        while (lutando) {
            int dado = random.nextInt(20) + 1;
            System.out.println("--------------------------------------------------------------------------------------------");

            System.out.println("Pontos de Vida\n"
                               + jogador.getNome() + ": " + arredondar(jogador.getVida()) + "\n"
                               + npc.getNome() + ": " + arredondar(npc.getVida()) + "\n");

            if (turnoDoJogador) {
                System.out.println("Sua vez!\n1 - Atacar \n2 - Fugir");
                acao = Escolhas.VerificaEntrada(2);
                if (acao.equals("2")) {
                    System.out.println("Você não estava preparado para a força do inimigo, e decide fugir para" +
                                       " que possa tentar novamente em uma próxima vez. \n - Fim de Jogo -");
                    System.exit(0);
                } else {
                    System.out.println("Rolamento do dado: " + dado);
                    if (dificuldade == NivelDificuldade.DIFICIL) {
                        dano = calculaDano(jogador, npc, dado, false);
                        dano -= (dano * 10) / 100;
                    } else {
                        dano = calculaDano(jogador, npc, dado, false);
                    }
                    npc.setVida(npc.getVida() - dano);

                    switch (jogador.getArma().getTipo()) {
                        case ESPADA -> frasePadrao = "Você atacou com sua Espada";
                        case MACHADO -> frasePadrao = "Você atacou com seu Machado";
                        case CLAVA -> frasePadrao = "Você atacou com sua Clava";
                        case MARTELO -> frasePadrao = "Você atacou com seu Martelo";
                        case ARCO -> frasePadrao = "Você atacou com seu Arco, a Flecha atingiu";
                        case BESTA -> frasePadrao = "Você atacou com sua Besta, o Virote atingiu";
                        case CAJADO -> frasePadrao = "Você atacou com seu Cajado, lançando uma bola de fogo";
                        case LIVRO -> frasePadrao = "Você atacou absorvendo energia do Livro com uma mão e liberando com a outra";
                    }
                    frasePadrao = frasePadrao + " e causou " + arredondar(dano) + " de dano no inimigo!";

                    if (dado == 1) {
                        System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
                    } else if (dado == 20) {
                        System.out.println("Você acertou um ataque crítico!" + frasePadrao);
                    } else {
                        System.out.println(frasePadrao);
                    }

                    if (npc.getVida() <= 0) {
                        venceu = true;
                        lutando = false;
                    } else {
                        turnoDoJogador = false;
                    }

                    System.out.println("--------------------------------------------------------------------------------------------");

                }

            } else {

                System.out.println("Rolamento do dado: " + dado);
                if (dificuldade == NivelDificuldade.FACIL) {
                    dano = calculaDano(npc, jogador, dado, false);
                    dano -= (dano * 20) / 100;
                } else {
                    dano = calculaDano(npc, jogador, dado, false);
                }
                jogador.setVida(jogador.getVida() - dano);

                if (dado == 1) {
                    System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
                } else if (dado == 20) {
                    System.out.println("O inimigo acertou um ataque crítico! Você sofreu " + arredondar(dano) + " de dano e agora possui " +
                                       (jogador.getVida() < 0 ? 0 : arredondar(jogador.getVida())) + " pontos de vida.");
                } else {
                    System.out.println("O inimigo atacou! Você sofreu " + arredondar(dano) + " de dano e agora possui " +
                                       (jogador.getVida() < 0 ? 0 : arredondar(jogador.getVida())) + " pontos de vida.");
                }

                if (jogador.getVida() <= 0) {
                    lutando = false;
                } else {
                    turnoDoJogador = true;
                }

                System.out.println("--------------------------------------------------------------------------------------------");

            }
        }

        return venceu;
    }

    public void armadilha(Personagem jogador) {
        int dado = random.nextInt(9) + 2;
        Double dano = calculaDano(null, jogador, dado, true);
        jogador.setVida(jogador.getVida() - dano);
        System.out.println("| Você sofreu " + arredondar(dano) + " de dano e agora possui " + arredondar(jogador.getVida()) + " pontos de vida. |\n");
    }

    public Double calculaDano(Personagem atacante, Personagem defensor, int dado, boolean isArmadilha) {
        double danoBase;
        int percentual = switch (dado) {
            case 2, 3 -> 10;
            case 4, 5 -> 20;
            case 6, 7 -> 30;
            case 8, 9 -> 40;
            case 10, 11 -> 50;
            case 12, 13 -> 60;
            case 14, 15 -> 70;
            case 16, 17 -> 80;
            case 18, 19 -> 90;
            case 20 -> 100;
            default -> 0;
        };

        if (isArmadilha) {
            danoBase = 40.0;
        } else {
            danoBase = atacante.getDano() + atacante.getArma().getDano();
        }

        return ((percentual * (danoBase - defensor.getDefesa())) / 100);
    }

    public void setDificuldade(String nivel) {
        switch (nivel) {
            case "1" -> this.dificuldade = NivelDificuldade.FACIL;
            case "2" -> this.dificuldade = NivelDificuldade.NORMAL;
            case "3" -> this.dificuldade = NivelDificuldade.DIFICIL;
        }
    }

    private static String arredondar(Double vida) {
        DecimalFormat df = new DecimalFormat("0.0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(vida);
    }
}
