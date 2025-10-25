package FIlas;

public class Celula {
    int elemento;
    Celula prox;

    public Celula(int elemento, Celula prox){
        this.elemento = elemento;
        this.prox = null;
    }

    public Celula() {
        //TODO Auto-generated constructor stub
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Celula getProx() {
        return prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }
}
