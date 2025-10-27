package Listas;

public class ListaEstatica {
    int[] vetor;
    int ultimo;
    int primeiro;

    public ListaEstatica() {
        this.vetor = new int[10];
        this.primeiro = 0;
        this.ultimo = 0;
    }

    public void inserir(int elemento, int posicao) throws Exception {
        if (ultimo == vetor.length) {
            throw new Exception("Vetor cheio");
        } else if (posicao < 0 || posicao > ultimo) {
            throw new Exception("Posição inválida");
        } else {
            for (int i = ultimo; i > posicao; i--) {
                vetor[i] = vetor[i - 1];
            }
            vetor[posicao] = elemento;
            ultimo++;
        }
    }

    public void remover(int posicao) throws Exception {
        if (ultimo == primeiro) {
            throw new Exception("Vetor vazio");
        } else if (posicao < 0 || posicao >= ultimo) {
            throw new Exception("Posição inválida");
        } else {
            int removido = vetor[posicao];
            for (int i = posicao; i < ultimo - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            ultimo--;
            System.out.println("Removido: " + removido);
        }
    }

    public void mostrar() {
        System.out.print("Lista: ");
        for (int i = primeiro; i < ultimo; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}
