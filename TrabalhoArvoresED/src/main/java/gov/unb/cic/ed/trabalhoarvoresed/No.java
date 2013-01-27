package gov.unb.cic.ed.trabalhoarvoresed;

public class No {

    private Object valor;
    private boolean alpha;
    private No pai;
    private ListaLigada filhos;
    private int casaMovida;

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public ListaLigada getFilhos() {
        return filhos;
    }

    public void setFilhos(ListaLigada filhos) {
        this.filhos = filhos;
    }

    public int getCasaMovida() {
        return casaMovida;
    }

    public void setCasaMovida(int casaMovida) {
        this.casaMovida = casaMovida;
    }

    public boolean isFolha() {
        return null == filhos;
    }

    public boolean isRaiz() {
        return null == pai;
    }

    public boolean isAlpha() {
        return alpha;
    }

    public void setAlpha(boolean alpha) {
        this.alpha = alpha;
    }

//	@Override
//	public String toString() {
//		return "\n\tNo [valor=" + valor + ", filhos=" + filhos + "]";
//	}
    public long contarFilhos() {
        if (filhos == null) {
            return 0;
        } else {
            Elemento e = filhos.getCabeca();
            long ret = 0;
            while (e != null) {
                ret += 1 + ((No) e.getValor()).contarFilhos();
                e = e.getProximo();
            }
            return ret;
        }
    }

    @Override
    public String toString() {
        return "\n\tNo [valor=" + valor + ", alpha=" + alpha + ", casaMovida=" + casaMovida + ", filhos=" + filhos + "]";
    }
}
