package gov.unb.cic.ed.trabalhoarvoresed;

public class ArvoreTest {

    public static void main(String[] args) {
        No n0, n1, n2, n3, n4;

        n0 = new No();
        n0.setAlpha(true);
        n0.setFilhos(new ListaLigada());

        n1 = new No();
        n1.setPai(n0);
        n1.setAlpha(false);
        n1.setFilhos(new ListaLigada());
        n0.getFilhos().insereInicio(new Elemento(n1));

        n2 = new No();
        n2.setPai(n1);
        n2.setAlpha(true);
        n2.setFilhos(new ListaLigada());
        n1.getFilhos().insereInicio(new Elemento(n2));

        n3 = new No();
        n3.setPai(n2);
        n3.setAlpha(false);
        n3.setFilhos(new ListaLigada());
        n2.getFilhos().insereInicio(new Elemento(n3));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(10);
        n3.getFilhos().insereInicio(new Elemento(n4));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(99999);
        n3.getFilhos().insereInicio(new Elemento(n4));
        //////////////////////////////////////////////////

        n3 = new No();
        n3.setPai(n2);
        n3.setAlpha(false);
        n3.setFilhos(new ListaLigada());
        n2.getFilhos().insereInicio(new Elemento(n3));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(5);
        n3.getFilhos().insereInicio(new Elemento(n4));
        ////////////////////////////////////////////////

        n2 = new No();
        n2.setPai(n1);
        n2.setAlpha(true);
        n2.setFilhos(new ListaLigada());
        n1.getFilhos().insereInicio(new Elemento(n2));

        n3 = new No();
        n3.setPai(n2);
        n3.setAlpha(false);
        n3.setFilhos(new ListaLigada());
        n2.getFilhos().insereInicio(new Elemento(n3));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(-10);
        n3.getFilhos().insereInicio(new Elemento(n4));
        //////////////////////////////////////////////////

        n1 = new No();
        n1.setPai(n0);
        n1.setAlpha(false);
        n1.setFilhos(new ListaLigada());
        n0.getFilhos().insereInicio(new Elemento(n1));

        n2 = new No();
        n2.setPai(n1);
        n2.setAlpha(true);
        n2.setFilhos(new ListaLigada());
        n1.getFilhos().insereInicio(new Elemento(n2));

        n3 = new No();
        n3.setPai(n2);
        n3.setAlpha(false);
        n3.setFilhos(new ListaLigada());
        n2.getFilhos().insereInicio(new Elemento(n3));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(7);
        n3.getFilhos().insereInicio(new Elemento(n4));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(5);
        n3.getFilhos().insereInicio(new Elemento(n4));
        //////////////////////////////////////////////////

        n3 = new No();
        n3.setPai(n2);
        n3.setAlpha(false);
        n3.setFilhos(new ListaLigada());
        n2.getFilhos().insereInicio(new Elemento(n3));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(-999);
        n3.getFilhos().insereInicio(new Elemento(n4));
        //////////////////////////////////////////////////

        n2 = new No();
        n2.setPai(n1);
        n2.setAlpha(true);
        n2.setFilhos(new ListaLigada());
        n1.getFilhos().insereInicio(new Elemento(n2));

        n3 = new No();
        n3.setPai(n2);
        n3.setAlpha(false);
        n3.setFilhos(new ListaLigada());
        n2.getFilhos().insereInicio(new Elemento(n3));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(-7);
        n3.getFilhos().insereInicio(new Elemento(n4));

        n4 = new No();
        n4.setPai(n3);
        n4.setAlpha(true);
        n4.setValor(-5);
        n3.getFilhos().insereInicio(new Elemento(n4));
        //////////////////////////////////////////////////
        Mancala.miniMax(n0);
        Arvore a = new Arvore();
        a.setRaiz(n0);
        System.out.println(a);
    }
}
