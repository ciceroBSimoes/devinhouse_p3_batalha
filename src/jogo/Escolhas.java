package jogo;

import java.util.Scanner;

public class Escolhas {

    public static String VerificaEntrada(int opcoes) {

        Scanner entrada = new Scanner(System.in);
        String opcao, escolha = null;
        int controle = 0;

        while (controle == 0) {
            System.out.print("Escolha o número: ");
            opcao = entrada.next();

            for (int i = 1; i <= opcoes; i++) {
                if (opcao.equals(String.valueOf(i))) {
                    controle++;
                }
            }
            if (controle == 0) {
                System.out.println("Opção inválida, tente novamente!");
            } else {
                escolha = opcao;
            }
        }

        return escolha;
    }

}
