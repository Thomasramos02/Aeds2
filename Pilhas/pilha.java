package Pilhas;

public class pilha {
    private int topo;
    private Object[] array;
    private int tamanho;
    
    public pilha(int capacidade) {
        this.topo = -1;
        this.array = new Object[capacidade];
        this.tamanho = capacidade;
    }

    public pilha() {
        this(10); // Construtor padrão com capacidade 10
    }

    // Verifica se a pilha está cheia
    public boolean isCheia() {
        return topo == tamanho - 1;
    }

    // Verifica se a pilha está vazia
    public boolean isVazia() {
        return topo == -1;
    }

    // Insere elemento na pilha
    public void inserir(Object elemento) {
        if (isCheia()) {
            // Cria novo array com tamanho dobrado
            Object[] novoArray = new Object[tamanho * 2];
            for (int i = 0; i <= topo; i++) {
                novoArray[i] = array[i];
            }
            array = novoArray;
            tamanho *= 2;
        }
        topo++;
        array[topo] = elemento;
    }

    // Remove elemento da pilha
    public Object remover() {
        if (isVazia()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        Object valor = array[topo];
        array[topo] = null; // Limpa a referência
        topo--;
        return valor;
    }

    // Consulta o topo da pilha
    public Object consultarTopo() {
        if (isVazia()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return array[topo];
    }
    
    // Retorna o tamanho atual da pilha
    public int getTamanho() {
        return topo + 1;
    }
}