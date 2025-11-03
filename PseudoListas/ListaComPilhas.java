package PseudoListas;

import Pilhas.pilha;
public class ListaComPilhas {
    private pilha principalPilha;
    private pilha auxiliar;
    private int tamanho;

    public ListaComPilhas() {
        principalPilha = new pilha();
        auxiliar = new pilha();
        tamanho = 0;
    }

    public void inserir(int posicao, Object item) {
        if(posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        for(int i = 0; i < tamanho - posicao; i++){
            auxiliar.inserir(principalPilha.remover());
        }
        principalPilha.inserir(item);

        while(!auxiliar.isVazia()){
            principalPilha.inserir(auxiliar.remover());
        }
        tamanho++;
    }

    public Object remover(int posicao) {
        if(posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if(principalPilha.isVazia()){
            throw new IllegalStateException("A lista está vazia");
        }

        for(int i = 0; i < tamanho - posicao - 1; i++){
            auxiliar.inserir(principalPilha.remover());
        }
        Object valorRemovido = principalPilha.remover();
        while(!auxiliar.isVazia()){
            principalPilha.inserir(auxiliar.remover());
        }
        tamanho--;
        return valorRemovido;
    }

    // Retorna o elemento em uma determinada posição
    public Object get(int posicao) {
        if(posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        
        Object elemento = null;
        for(int i = 0; i < tamanho - posicao - 1; i++){
            auxiliar.inserir(principalPilha.remover());
        }
        elemento = principalPilha.consultarTopo();
        
        while(!auxiliar.isVazia()){
            principalPilha.inserir(auxiliar.remover());
        }
        return elemento;
    }

    // Atualiza o elemento em uma determinada posição
    public void set(int posicao, Object item) {
        if(posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        
        for(int i = 0; i < tamanho - posicao - 1; i++){
            auxiliar.inserir(principalPilha.remover());
        }
        principalPilha.remover(); 
        principalPilha.inserir(item); 
        
        while(!auxiliar.isVazia()){
            principalPilha.inserir(auxiliar.remover());
        }
    }

    
    public int getTamanho() {
        return tamanho;
    }

    
    public boolean isVazia() {
        return tamanho == 0;
    }
}