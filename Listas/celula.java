package Listas;

public class celula {
    celula prox;
    celula anterior;
    int elemento;

    public celula(int elemento, celula prox, celula anterior){
        this.elemento = elemento;
        this.prox = prox;
        this.anterior = anterior;
    }

    public celula getProx() {
        return prox;
    }

    public void setProx(celula prox) {
        this.prox = prox;
    }

    public celula getAnterior() {
        return anterior;
    }

    public void setAnterior(celula anterior) {
        this.anterior = anterior;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }
}
