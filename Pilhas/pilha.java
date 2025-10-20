package Pilhas;

public class pilha{
    int topo;
    int[] x;

    //verifica se a pilha esta cheia
    public void cheia(){
        if(x.length == topo){
            System.out.println("Pilha esta cheia");
        }
    }

    //verifica se a pilha esta vazia
    public void Vazia(){
        if(topo == 0){
            System.out.println("Pilha esta vazia");
        }
    }

    //inseri elemento na pilha
    public void Inserir(int elemento){
        if(x.length == topo){
            System.out.println("Pilha esta cheia, não é possivel inserir");
        }else{
            topo++;
            x[topo] = elemento;
        }
    }

    //remove elemento da pilha
    public void remover(){
        if(topo == 0){
            System.out.println("A pilha esta vazia, não é possivel remover");
        }else{
            int valor = x[topo];
            topo--;

            System.out.println("Valor removido: "+valor);
        }
    }

    //fazer consultar Pilha


}