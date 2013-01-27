package gov.unb.cic.ed.trabalhoarvoresed;

public class ListaLigada {

    private Elemento cabeca;

    public ListaLigada() {
        cabeca = null;
    }

    public void insereInicio(Elemento elemento) {
        elemento.setProximo(cabeca);
        cabeca = elemento;
    }

    public void insereFim(Elemento elemento) {
        elemento.setProximo(cabeca);
        cabeca = elemento;
    }

    public Elemento getCabeca() {
        return cabeca;
    }

    public boolean isVazia() {
        return cabeca == null;
    }

    @Override
    public String toString() {
        Elemento e = cabeca;
        String ret = "";
        while (e != null) {
            ret += e.getValor().toString() + ";";
            e = e.getProximo();
        }
        return "ListaLigada [" + ret + "]";
    }
}
