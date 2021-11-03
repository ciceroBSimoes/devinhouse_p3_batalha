package jogo;

import personagem.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String opcaoClasse, opcaoArma, motivacao, seguirOuDesistir, entraNaSala, pegarArmadura, beberPocao;
        boolean acao;
        Scanner entrada = new Scanner(System.in);
        Jogo novoJogo = new Jogo();
        Personagem jogador = new Personagem();

        List<Classe> classes = new ArrayList<>();
        for (TipoClasse tipo : TipoClasse.values()) {
            classes.add(new Classe(tipo));
        }

        List<Npc> npcs = new ArrayList<>();
        npcs.add(new Npc("Burguk o Armeiro", 14.0, 12.0, new Arma(TipoArmaEnum.ESPADA)));
        npcs.add(new Npc("Borgakh a Alquimista", 14.0, 10.0, new Arma(TipoArmaEnum.CAJADO)));
        npcs.add(new Npc("Mauhulakh o Chefe", 18.0, 12.0, new Arma(TipoArmaEnum.MACHADODUPLO)));


        System.out.println(" - Seja bem vindo(a) à BATALHA FINAL! - ");

        System.out.println("\nDefina o nível de dificuldade\n1 - Fácil\n2 - Normal\n3 - Difícil");
        novoJogo.setDificuldade(Escolhas.VerificaEntrada(3));

        System.out.print("\nDefina o nome do seu/sua personagem: ");
        jogador.setNome(entrada.next());

        System.out.println("\nDefina o gênero do seu/sua personagem\n1 - Masculino\n2 - Feminino");
        jogador.setGenero(Escolhas.VerificaEntrada(2));

        System.out.println("\nDefina a classe de combate de " + jogador.getNome());
        for (Classe classe : classes) {
            if (!classe.getNomeClasse().equals("Npc")) {
                System.out.println(classe.getId() + " - " + classe.getNomeClasse() + " (ATK " + classe.getDano() + ", DEF " + classe.getDefesa() + ")");
            }
        }
        opcaoClasse = Escolhas.VerificaEntrada(classes.size() - 1);
        for (Classe classe : classes) {
            if (classe.getId() != null && classe.getId().equals(opcaoClasse)) {
                jogador.setClasseDeCombate(classe);
            }
        }

        System.out.println("\nDefina sua arma:");
        int count = 1;
        List<Arma> armas = jogador.getClasseDeCombate().getArmas();

        for (Arma arma : armas) {
            System.out.println(count + " - " + arma.getNomeArma() + " | ATK " + arma.getDano());
            count++;
        }
        opcaoArma = Escolhas.VerificaEntrada(count - 1);
        jogador.setArma(armas.get(Integer.parseInt(opcaoArma) - 1));

        //

        System.out.println("""
                                
                A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do crepúsculo
                você está prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente, e
                sabe que a partir desse ponto, sua vida mudará para sempre.
                                
                Memórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de
                todos os inimigos já derrotados para alcançar o covil do líder maligno. Olha para seu
                equipamento de combate, já danificado e desgastado depois de tantas lutas. Você está a um
                passo de encerrar para sempre esse mal.
                                
                Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.
                1 - Vingança
                2 - Glória
                """);

        motivacao = Escolhas.VerificaEntrada(2);
        if (motivacao.equals("1")) {
            System.out.println("""
                                        
                    Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar
                    para lembrar, pois essas memórias estão sempre presentes, mesmo que de pano de fundo,
                    quando você tem outros pensamentos em foco, elas nunca o deixaram. Elas são o combustível
                    que te fizeram chegar até aqui. E você sabe que não irá desistir até ter vingado a morte daqueles
                    que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo. O maldito líder
                    finalmente pagará por tanto mal causado na vida de tantos (e principalmente na sua).
                    """);
        } else {
            System.out.println("""
                                        
                    Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços
                    abertos, bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e
                    diversas riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilanças. Desde
                    já, você sente o amor do público, te louvando a cada passo que dá pelas ruas, depois de destruir
                    o vilão que tanto assombrou a paz de todos. Porém, você sabe que ainda falta o último ato dessa
                    história. Você se concentra na missão. A glória o aguarda, mas não antes da última batalha.
                    """);
        }

        System.out.println("""
                Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas
                mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.
                Você avança pelo portal.
                                
                A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua
                frente, só é possível perceber que você se encontra em um corredor extenso. Você só pode ir à
                frente, ou desistir.
                1 - Seguir em frente
                2 - Desistir""");
        seguirOuDesistir = Escolhas.VerificaEntrada(2);
        if (seguirOuDesistir.equals("2")) {
            System.out.println("""
                                        
                    O medo invade o seu coração e você sente que ainda não está à altura do desafio.
                    Você se volta para a noite lá fora e corre em direção à segurança.
                    -- Fim de Jogo! --
                    """);
            System.exit(0);
        }

        System.out.println("""
                                
                Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente
                uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta
                aberta.
                Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, e pondera
                sobre como passar pela porta.
                1 - Andando cuidadosamente
                2 - Correndo
                3 - Saltando""");
        entraNaSala = Escolhas.VerificaEntrada(3);
        if (entraNaSala.equals("1")) {
            System.out.println("""
                                        
                    Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você
                    pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado
                    em uma pedra solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se
                    abre no teto atrás de você, no corredor. Flechas voam da escotilha em sua direção, e você salta
                    para dentro da sala, porém uma delas te acerta na perna.
                    """);
            novoJogo.armadilha(jogador);
        } else if (entraNaSala.equals("2")) {
            System.out.println("""
                                        
                    Você respira fundo e desata a correr em direção à sala. Quando passa pela porta,
                    sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala,
                    olhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de flechas
                    batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão. Espiando pela porta,
                    você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,
                    mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.
                    """);
        } else {
            System.out.println("""
                                        
                    Você se concentra e pula em direção à luz, saltando de antes da porta até o interior
                    da sala.
                    """);
        }

        System.out.println("""
                Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma
                delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. A
                porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você
                não sabe ler, mas reconhece como sendo a língua antiga utilizada pelo inimigo. Você se aproxima
                da porta e percebe que ela está trancada por duas fechaduras douradas, e você entende que
                precisará primeiro derrotar o que estiver nas outras duas portas laterais, antes de conseguir
                enfrentar o líder.
                                
                Você se dirige para a porta à direita.
                                
                Você se aproxima, tentando ouvir o que acontece porta adentro, mas não
                escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra a porta com a
                outra. Ao entrar, você se depara com uma sala espaçosa, com vários equipamentos de batalha
                pendurados nas paredes e dispostos em armários e mesas. Você imagina que este seja o arsenal
                do inimigo, onde estão guardados os equipamentos que seus soldados utilizam quando saem
                para espalhar o terror nas cidades e vilas da região.
                                
                Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar
                para trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um
                dos capitães do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em
                posição de combate. Ele avança em sua direção.
                """);

        if (novoJogo.combate(jogador, npcs.get(0), false)) {
            System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
        } else {
            System.out.println("Você não estava preparado para a força do inimigo.");
            if (motivacao.equals("1")) {
                System.out.println("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
            } else {
                System.out.println("\nA glória que buscavas não será sua, e a cidade aguarda por "
                                   + (jogador.getGenero().equals(GeneroEnum.MASCULINO) ? "seu próximo herói." : "sua próxima heroína."));
            }
            System.out.println("\n - Fim de Jogo - ");
            System.exit(0);
        }

        System.out.println("""
                Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha
                em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.
                Pegar armaduras novas?
                1 - Sim
                2 - Não
                """);
        pegarArmadura = Escolhas.VerificaEntrada(2);
        if (pegarArmadura.equals("1")) {
            jogador.setDefesa(jogador.getDefesa() + 5);
            System.out.println("""
                                        
                    Você resolve usar os equipamentos do inimigo contra ele,
                    e trocar algumas peças suas, que estavam danificadas, pelas peças de
                    armaduras existentes na sala. De armadura nova, você se sente mais protegido para os desafios
                    à sua frente. Defesa aumentada.
                    """);
        } else {
            System.out.println("\nVocê decide que não precisa utilizar nada que venha das mãos do inimigo.");
        }

        System.out.println("""
                Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das
                fechaduras da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva
                presa ao cinto.
                                
                Você retorna à sala anterior e se dirige à porta da esquerda. Você se
                aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais
                força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara
                com uma sala parecida com a do arsenal, mas em vez de armaduras, existem vários potes e
                garrafas de vidro com conteúdos misteriosos e de cores diversas, e você entende que o capitão
                que vive ali, realiza experimentos com diversos ingredientes, criando poções utilizadas pelos
                soldados para aterrorizar a região.
                                
                No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque
                horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.
                """);
        if (novoJogo.combate(jogador, npcs.get(1), false)) {
            System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
        } else {
            System.out.println("Você não estava preparado para a força do inimigo.");
            if (motivacao.equals("1")) {
                System.out.println("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
            } else {
                System.out.println("\nA glória que buscavas não será sua, e a cidade aguarda por "
                                   + (jogador.getGenero().equals(GeneroEnum.MASCULINO) ? "seu próximo herói." : "sua próxima heroína."));
            }
            System.out.println("\n - Fim de Jogo - ");
            System.exit(0);
        }

        System.out.println("""
                Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque
                do inimigo. Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido
                levemente rosado, pega a garrafa e pondera se deve beber um gole.
                Beber a poção?
                1 - Sim
                2 - Não
                """);
        beberPocao = Escolhas.VerificaEntrada(2);
        if (beberPocao.equals("1")) {
            System.out.println("\nVocê se sente revigorado para seguir adiante! Pontos de vida restaurados.");
            jogador.setVida(100.0);
        } else {
            System.out.println("\nVocê fica receoso de beber algo produzido pelo inimigo.");
        }

        System.out.println("""
                Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave
                abre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa
                que leva presa ao cinto.
                                
                De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a
                porta se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você
                percebe que está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca
                no combate que você sabe que irá se seguir, e adentra a porta.
                                
                Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e
                prisioneiros acorrentados às paredes.
                Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de
                lâmina dupla.
                                
                Atacar primeiro ou esperar?
                1 - Atacar
                2 = Esperar
                """);

        acao = Escolhas.VerificaEntrada(2).equals("1");

        if (novoJogo.combate(jogador, npcs.get(2), acao)) {
            System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.\n" +
                               "- Você conseguiu! -");
            if (motivacao.equals("1")) {
                System.out.println("""
                        Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma
                        sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você
                        pode seguir sua vida.
                        """);
            } else {
                System.out.println("""
                        O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de
                        alegria. A glória o aguarda, você a conquistou.
                        """);
            }
            System.out.println("""
                    Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em
                    direção à noite, retornando à cidade. Seu dever está cumprido.
                                        
                    """);
        } else {
            System.out.println("Você não estava preparado para a força do inimigo.");
            if (motivacao.equals("1")) {
                System.out.println("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
            } else {
                System.out.println("\nA glória que buscavas não será sua, e a cidade aguarda por "
                                   + (jogador.getGenero().equals(GeneroEnum.MASCULINO) ? "seu próximo herói." : "sua próxima heroína."));
            }
            System.out.println("\n - Fim de Jogo - ");
            System.exit(0);
        }
    }
}
