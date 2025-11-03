package FIlas;

public class Celula {
    private Object elemento;
    private Celula prox;

    // Construtor para criar célula vazia
    public Celula() {
        this(null);
    }

    // Construtor para criar célula com elemento
    public Celula(Object elemento) {
        this.elemento = elemento;
        this.prox = null;
    }

    // Getters e Setters
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Celula getProx() {
        return prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }
}
