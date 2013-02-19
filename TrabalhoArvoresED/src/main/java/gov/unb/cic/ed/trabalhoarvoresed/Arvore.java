package gov.unb.cic.ed.trabalhoarvoresed;

public class Arvore {

    private No raiz;

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public boolean isVazia() {
        return null == raiz;
    }
    
    @Override
    public String toString() {
        return formataNo(raiz, "");
    }
    
    private String formataNo(No no, String prefixo){
        String ret = prefixo + "+-(" + no.isAlpha() + "|" + no.getValor() + ")\n";
        if(no.getFilhos() != null){
            Elemento e = no.getFilhos().getCabeca();
            while(e!=null){               
                ret += formataNo((No)e.getValor(), prefixo + 
                        (e.getProximo() != null ? "|" : " "));
                e = e.getProximo();
            }
        }
        return ret;
    }

    public long contarNos() {
        if (isVazia()) {
            return 0;
        } else {
            return 1 + raiz.contarFilhos();
        }
    }
}
