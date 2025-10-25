package Pilhas;

public class pilha{
    int topo;
    int[] x;
    
    public pilha(int[] x) {
        this.topo = -1;
        this.x = x;
    }

    //verifica se a pilha esta cheia
    public Boolean isCheia(){
        if(topo == x.length - 1){
            return true;
        }
        return false;
    }

    //verifica se a pilha esta vazia
    public Boolean isVazia(){
        if(topo == -1){
            return true;
        }
        return false;
    }

    //inseri elemento na pilha
    public void Inserir(int elemento){
        if(topo == x.length-1){
            System.out.println("Pilha esta cheia, não é possivel inserir");
        }else{
           topo++;
           x[topo] =elemento;
        }
    }

    //remove elemento da pilha
    public void remover(){
        if(topo == -1){
            System.out.println("A pilha esta vazia, não é possivel remover");
        }else{
            int valor = x[topo];
            topo--;
            System.out.println("Valor removido: "+valor);
        }
    }

    //consulta o topo da pilha
    public int ConsultarTopo(){
        if(topo == -1){
            throw new IllegalStateException();
        }
        return x[topo];
    }

}