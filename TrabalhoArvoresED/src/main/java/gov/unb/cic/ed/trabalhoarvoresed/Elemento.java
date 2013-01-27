package gov.unb.cic.ed.trabalhoarvoresed;

public class Elemento {

    private Object valor;
    private Elemento proximo;

    public Elemento(Object valor) {
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Elemento [valor=" + valor + "]";
    }
}
