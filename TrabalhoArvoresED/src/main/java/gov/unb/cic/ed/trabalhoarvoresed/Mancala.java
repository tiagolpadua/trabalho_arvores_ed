package gov.unb.cic.ed.trabalhoarvoresed;

public class Mancala implements Cloneable {

    private int[] vetorCasasJ1 = new int[7];
    private int[] vetorCasasJ2 = new int[7];
    public int vezJogador;

    public Mancala() {
        resetar();
    }

    public int getVezJogador() {
        return vezJogador;
    }

    public void setVezJogador(int vezJogador) {
        this.vezJogador = vezJogador;
    }

    public boolean isVezJogador1() {
        return 1 == vezJogador;
    }

    public boolean isVezJogador2() {
        return !isVezJogador1();
    }

    public int getCasaJ1(int n) {
        if (n == 7) {
            throw new RuntimeException("Casa inv�lida.");
        }
        return vetorCasasJ1[n - 1];
    }

    public int getPocoJ1() {
        return vetorCasasJ1[6];
    }

    public void setPocoJ1(int n) {
        vetorCasasJ1[6] = n;
    }

    public int getCasaJ2(int n) {
        if (n == 7) {
            throw new RuntimeException("Casa inv�lida.");
        }
        return vetorCasasJ2[n - 1];
    }

    public int getPocoJ2() {
        return vetorCasasJ2[6];
    }

    public void setPocoJ2(int n) {
        vetorCasasJ2[6] = n;
    }

    public void setCasaJ1(int n, int valor) {
        if (n == 7) {
            throw new RuntimeException("Casa inv�lida.");
        }
        vetorCasasJ1[n - 1] = valor;
    }

    public void setCasaJ2(int n, int valor) {
        if (n == 7) {
            throw new RuntimeException("Casa inv�lida.");
        }
        vetorCasasJ2[n - 1] = valor;
    }

    // Retorna true se houver jogada bonus
    private static boolean mover(int casa, int[] vetorCasasJogador, int[] vetorCasasAdversario) throws MancalaException {
        if (casa < 1 || casa > 6) {
            throw new MancalaException("Posi��o inv�lida.");
        }

        int mao = vetorCasasJogador[casa - 1];
        if (mao == 0) {
            throw new MancalaException("Jogada inv�lida - n�o h� pe�as na posi��o indicada.");
        }

        vetorCasasJogador[casa - 1] = 0;
        int casaAtual = casa + 1;

        while (mao > 0) {
            while (casaAtual <= 6 && mao > 0) {
                vetorCasasJogador[casaAtual - 1]++;
                mao--;
                if (mao == 0 && vetorCasasJogador[casaAtual - 1] == 1) {
                    vetorCasasJogador[casaAtual - 1] = 0;
                    vetorCasasJogador[6]++;

                    int casaAdversario = 7 - casaAtual;
                    vetorCasasJogador[6] += vetorCasasAdversario[casaAdversario - 1];
                    vetorCasasAdversario[casaAdversario - 1] = 0;
                }
                casaAtual++;
            }

            if (mao > 0) {
                vetorCasasJogador[6]++;
                mao--;
                if (mao == 0) {
                    return true;
                }
            }

            casaAtual = 1;
            while (casaAtual <= 6 && mao > 0) {
                vetorCasasAdversario[casaAtual - 1]++;
                mao--;
                casaAtual++;
            }
            casaAtual = 1;
        }

        return false;
    }

    public void moverJ1(int casa) throws MancalaException {
        if (isVezJogador2()) {
            throw new RuntimeException("Jogador errado!");
        }

        if (!mover(casa, vetorCasasJ1, vetorCasasJ2)) {
            vezJogador = 2;
        }

        if (jogoTerminou()) {
            terminarTabuleiro();
        }
    }

    public void moverJ2(int casa) throws MancalaException {
        if (isVezJogador1()) {
            throw new RuntimeException("Jogador errado!");
        }
        if (!mover(casa, vetorCasasJ2, vetorCasasJ1)) {
            vezJogador = 1;
        }

        if (jogoTerminou()) {
            terminarTabuleiro();
        }
    }

    public void terminarTabuleiro() {
        for (int i = 0; i < 6; i++) {
            vetorCasasJ1[6] += vetorCasasJ1[i];
            vetorCasasJ1[i] = 0;

            vetorCasasJ2[6] += vetorCasasJ2[i];
            vetorCasasJ2[i] = 0;
        }
    }

    public void resetar() {
        vezJogador = 1;
        for (int i = 0; i < 6; i++) {
            vetorCasasJ1[i] = 4;
            vetorCasasJ2[i] = 4;
        }

        vetorCasasJ1[6] = 0;
        vetorCasasJ2[6] = 0;
    }

    public boolean jogoTerminou() {
        boolean terminou1 = true;
        boolean terminou2 = true;

        for (int i = 0; i < 6; i++) {
            if (vetorCasasJ1[i] != 0) {
                terminou1 = false;
            }

            if (vetorCasasJ2[i] != 0) {
                terminou2 = false;
            }
        }

        return terminou1 || terminou2;
    }

    public String toString() {
        // 6 5 4 3 2 1
        // / 12 - .4 - .5 - 12 - .4 - .5 \
        // 10 -------------------------- 20
        // \ 12 - .4 - .5 - 12 - .4 - .5 /
        // 1 2 3 4 5 6
        String ret = "/";

        for (int i = 5; i >= 0; i--) {
            ret += vetorCasasJ2[i] < 10 ? "  " + Integer.toString(vetorCasasJ2[i]) + " " : " " + Integer.toString(vetorCasasJ2[i]) + " ";
            if (i > 0) {
                ret += "-";
            }
        }
        ret += "\\\n";

        ret += vetorCasasJ2[6] < 10 ? " " + Integer.toString(vetorCasasJ2[6]) : Integer.toString(vetorCasasJ2[6]);
        ret += " -------------------------- ";
        ret += vetorCasasJ1[6] < 10 ? " " + Integer.toString(vetorCasasJ1[6]) : Integer.toString(vetorCasasJ1[6]);
        ret += "\n\\";

        for (int i = 0; i <= 5; i++) {
            ret += vetorCasasJ1[i] < 10 ? "  " + Integer.toString(vetorCasasJ1[i]) + " " : " " + Integer.toString(vetorCasasJ1[i]) + " ";
            if (i < 5) {
                ret += "-";
            }
        }
        ret += "/";

        return ret;
    }

    @Override
    public Object clone() {
        Mancala m = new Mancala();
        for (int i = 1; i <= 6; i++) {
            m.setCasaJ1(i, this.getCasaJ1(i));
            m.setCasaJ2(i, this.getCasaJ2(i));
        }
        m.setPocoJ1(this.getPocoJ1());
        m.setPocoJ2(this.getPocoJ2());

        m.setVezJogador(this.getVezJogador());

        return m;
    }

    public static Arvore obterArvoreDeJogadas(Mancala m, int niveis) throws MancalaException {
        Arvore a = new Arvore();
        a.setRaiz(obterNoDeJogadas(m, niveis, null, 0));
        return a;
    }

    private static No obterNoDeJogadas(Mancala m, int niveis, No pai, int casaMovida) throws MancalaException {
        No no = new No();
        no.setAlpha(m.isVezJogador2());
        no.setPai(pai);
        no.setCasaMovida(casaMovida);
        if (niveis > 0) {
            ListaLigada filhos = new ListaLigada();
            no.setFilhos(filhos);
            for (int i = 1; i <= 6; i++) {
                if (m.isVezJogador1()) {
                    if (m.getCasaJ1(i) > 0) {
                        Mancala m1 = (Mancala) m.clone();
                        m1.moverJ1(i);
                        filhos.insereInicio(new Elemento(obterNoDeJogadas(m1, niveis - 1, no, i)));
                    }
                } else {
                    if (m.getCasaJ2(i) > 0) {
                        Mancala m1 = (Mancala) m.clone();
                        m1.moverJ2(i);
                        filhos.insereInicio(new Elemento(obterNoDeJogadas(m1, niveis - 1, no, i)));
                    }
                }
            }
            if (filhos.getCabeca() == null) {
                no.setFilhos(null);
                no.setValor(m.getPocoJ2() - m.getPocoJ1());
            }
        } else {
            no.setValor(m.getPocoJ2() - m.getPocoJ1());
            // if (m.isVezJogador1()) {
            // no.setValor(m.getPocoJ1() * -1);
            // } else {
            // no.setValor(m.getPocoJ2());
            // }
        }
        return no;
    }

    public static void miniMax(No no) {
        if (no.getValor() == null) {
            Elemento e = no.getFilhos().getCabeca();
            while (e != null) {
                miniMax((No) e.getValor());
                e = e.getProximo();
            }
        }
        if (!no.isRaiz()) {
            if (no.getPai().getValor() == null) {
                no.getPai().setValor(no.getValor());
            } else {
                if (no.getPai().isAlpha()) {
                    no.getPai().setValor(Math.max(((Integer) no.getPai().getValor()).intValue(), ((Integer) no.getValor()).intValue()));
                }

                if (!no.getPai().isAlpha()) {
                    no.getPai().setValor(Math.min(((Integer) no.getPai().getValor()).intValue(), ((Integer) no.getValor()).intValue()));
                }
            }
        }
    }
}
