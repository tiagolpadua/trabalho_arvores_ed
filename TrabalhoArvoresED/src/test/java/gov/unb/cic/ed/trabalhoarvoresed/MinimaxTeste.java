package gov.unb.cic.ed.trabalhoarvoresed;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MinimaxTeste
        extends TestCase {

    public MinimaxTeste(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(MinimaxTeste.class);
    }

    public void testApp() {
         No n00;
         No n10,  n11;
         No n20,  n21, n22, n23;
         No n30,  n31, n32, n33, n34, n35;
         No n40,  n41, n42, n43, n44, n45, n46, n47, n48;

//      NIVEL 0
        n00 = new No();
        n00.setAlpha(true);
        n00.setFilhos(new ListaLigada());

//      NIVEL 1
        n10 = new No();
        n10.setPai(n00);
        n10.setAlpha(false);
        n10.setFilhos(new ListaLigada());
        n00.getFilhos().insereInicio(new Elemento(n10));
        
        n11 = new No();
        n11.setPai(n00);
        n11.setAlpha(false);
        n11.setFilhos(new ListaLigada());
        n00.getFilhos().insereInicio(new Elemento(n11));
        
//      NIVEL 2
        n20 = new No();
        n20.setPai(n10);
        n20.setAlpha(true);
        n20.setFilhos(new ListaLigada());
        n10.getFilhos().insereInicio(new Elemento(n20));        
        
        n21 = new No();
        n21.setPai(n10);
        n21.setAlpha(true);
        n21.setFilhos(new ListaLigada());
        n10.getFilhos().insereInicio(new Elemento(n21));
        
        n22 = new No();
        n22.setPai(n11);
        n22.setAlpha(true);
        n22.setFilhos(new ListaLigada());
        n11.getFilhos().insereInicio(new Elemento(n22));        
        
        n23 = new No();
        n23.setPai(n11);
        n23.setAlpha(true);
        n23.setFilhos(new ListaLigada());
        n11.getFilhos().insereInicio(new Elemento(n23));        
                        
//      NIVEL 3
        n30 = new No();
        n30.setPai(n20);
        n30.setAlpha(false);
        n30.setFilhos(new ListaLigada());
        n20.getFilhos().insereInicio(new Elemento(n30));                
        
        n31 = new No();
        n31.setPai(n20);
        n31.setAlpha(false);
        n31.setFilhos(new ListaLigada());
        n20.getFilhos().insereInicio(new Elemento(n31));                
        
        n32 = new No();
        n32.setPai(n21);
        n32.setAlpha(false);
        n32.setFilhos(new ListaLigada());
        n21.getFilhos().insereInicio(new Elemento(n32));                
        
        n33 = new No();
        n33.setPai(n22);
        n33.setAlpha(false);
        n33.setFilhos(new ListaLigada());
        n22.getFilhos().insereInicio(new Elemento(n33));                
        
        n34 = new No();
        n34.setPai(n22);
        n34.setAlpha(false);
        n34.setFilhos(new ListaLigada());
        n22.getFilhos().insereInicio(new Elemento(n34));                
        
        n35 = new No();
        n35.setPai(n23);
        n35.setAlpha(false);
        n35.setFilhos(new ListaLigada());
        n23.getFilhos().insereInicio(new Elemento(n35));                
        
//      NIVEL 4        
        n40 = new No();
        n40.setPai(n30);
        n40.setAlpha(true);
        n40.setValor(10);
        n40.setFilhos(new ListaLigada());
        n30.getFilhos().insereInicio(new Elemento(n40));
        
        n41 = new No();
        n41.setPai(n30);
        n41.setAlpha(true);
        n41.setValor(Integer.MAX_VALUE);
        n41.setFilhos(new ListaLigada());
        n30.getFilhos().insereInicio(new Elemento(n41));
        
        n42 = new No();
        n42.setPai(n31);
        n42.setAlpha(true);
        n42.setValor(5);
        n42.setFilhos(new ListaLigada());
        n31.getFilhos().insereInicio(new Elemento(n42));
        
        n43 = new No();
        n43.setPai(n32);
        n43.setAlpha(true);
        n43.setValor(-10);
        n43.setFilhos(new ListaLigada());
        n32.getFilhos().insereInicio(new Elemento(n43));
        
        n44 = new No();
        n44.setPai(n33);
        n44.setAlpha(true);
        n44.setValor(7);
        n44.setFilhos(new ListaLigada());
        n33.getFilhos().insereInicio(new Elemento(n44));
        
        n45 = new No();
        n45.setPai(n33);
        n45.setAlpha(true);
        n45.setValor(5);
        n45.setFilhos(new ListaLigada());
        n33.getFilhos().insereInicio(new Elemento(n45));
        
        n46 = new No();
        n46.setPai(n34);
        n46.setAlpha(true);
        n46.setValor(Integer.MIN_VALUE);
        n46.setFilhos(new ListaLigada());
        n34.getFilhos().insereInicio(new Elemento(n46));
        
        n47 = new No();
        n47.setPai(n35);
        n47.setAlpha(true);
        n47.setValor(-7);
        n47.setFilhos(new ListaLigada());
        n35.getFilhos().insereInicio(new Elemento(n47));
        
        n48 = new No();
        n48.setPai(n35);
        n48.setAlpha(true);
        n48.setValor(-5);
        n48.setFilhos(new ListaLigada());
        n35.getFilhos().insereInicio(new Elemento(n48));
                
        //////////////////////////////////////////////////
        Mancala.miniMax(n00);
        Arvore a = new Arvore();
        a.setRaiz(n00);
        System.out.println(a);
    }
}
