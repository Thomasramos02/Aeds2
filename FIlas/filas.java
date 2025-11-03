package FIlas;

public class filas {
    private Celula primeiro;
    private Celula ultimo;
    private int tamanho;

    public filas() {
        primeiro = new Celula();
        ultimo = primeiro;
        tamanho = 0;
    }

    public void inserir(Object elemento) {
        ultimo.setProx(new Celula(elemento));
        ultimo = ultimo.getProx();
        tamanho++;
    }

    public Object remover() {
        if (isVazia()) {
            throw new IllegalStateException("Erro: Fila vazia");
        }

        Celula removida = primeiro.getProx();
        primeiro.setProx(removida.getProx());
        Object elemento = removida.getElemento();
        
        if (primeiro.getProx() == null) {
            ultimo = primeiro;
        }
        
        tamanho--;
        removida.setProx(null);
        return elemento;
    }

    public Object consultarPrimeiro() {
        if (isVazia()) {
            throw new IllegalStateException("Erro: Fila vazia");
        }
        return primeiro.getProx().getElemento();
    }

    public Object consultarUltimo() {
        if (isVazia()) {
            throw new IllegalStateException("Erro: Fila vazia");
        }
        return ultimo.getElemento();
    }

    public void mostrar() {
        if (isVazia()) {
            System.out.println("Fila vazia");
            return;
        }

        System.out.print("Fila: ");
        for (Celula i = primeiro.getProx(); i != null; i = i.getProx()) {
            System.out.print(i.getElemento() + " ");
        }
        System.out.println();
    }

    public boolean isVazia() {
        return primeiro == ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }
}
