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
        return "Arvore [raiz=" + raiz + "]";
    }

    public long contarNos() {
        if (isVazia()) {
            return 0;
        } else {
            return 1 + raiz.contarFilhos();
        }
    }
}
