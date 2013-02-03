package gov.unb.cic.ed.trabalhoarvoresed;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MancalaConsole {

    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Mancala m = new Mancala();
        int numeroNiveis = 0;
        do {
            System.out.println("Digite o número de níveis (1-9):");
            try {
                numeroNiveis = Integer.parseInt(buffer.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } while (numeroNiveis < 1 || numeroNiveis > 9);

        System.out.println(m);
        while (!m.jogoTerminou()) {
            if (m.isVezJogador1()) {
                System.out.println("Digite o movimento do jogador 1:");
                int casa = 0;
                try {
                    casa = Integer.parseInt(buffer.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }

                try {
                    m.moverJ1(casa);
                } catch (MancalaException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else {
                System.out.println("Aguarde, o computador está pensando...");
                long ti = System.currentTimeMillis();
                Arvore a = null;
                try {
                    a = Mancala.obterArvoreDeJogadas(m, numeroNiveis);
                } catch (MancalaException e2) {
                    throw new RuntimeException(e2.getMessage());
                }
                Mancala.miniMax(a.getRaiz());
                System.out.println("Quantidade de jogadas analisadas: " + a.contarNos());
                long tf = System.currentTimeMillis();
                System.out.println("Computador pensou por: " + (tf - ti) / 1000d + " segundos.");
                Elemento e = a.getRaiz().getFilhos().getCabeca();
                while (e != null) {
                    No no = (No) e.getValor();
                    if (no.getValor().equals(a.getRaiz().getValor())) {
                        System.out.println("Computador move: " + no.getCasaMovida());
                        try {
                            m.moverJ2(no.getCasaMovida());
                        } catch (MancalaException e1) {
                            System.out.println(e1.getMessage());
                            continue;
                        }
                        break;
                    }
                    e = e.getProximo();
                }
            }
            System.out.println(m);
        }
        System.out.println("Jogo terminou");
        if (m.getPocoJ1() > m.getPocoJ2()) {
            System.out.println("Jogador 1 ganhou.");
        } else if (m.getPocoJ2() > m.getPocoJ1()) {
            System.out.println("Jogador 2 (Computador) ganhou.");
        } else {
            System.out.println("Empate.");
        }

    }
}
