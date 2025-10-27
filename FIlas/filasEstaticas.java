package FIlas;


public class filasEstaticas{
    int[] array;
    int primeiro, ultimo = 0;

    public filasEstaticas(){
        this.array = new int[5];
        this.primeiro = ultimo;
    }

    public void inserir(int x){
        if((ultimo+1) % array.length == primeiro){
            System.out.println("Erro fila esta cheia");
            return;
        }
        array[ultimo] = x;
        ultimo = (ultimo + 1) % array.length;
    }

    public int remover(){
        if(ultimo == primeiro){
            System.out.println("Erro fila esta vazia");
            return -1;
        }
        int resp = array[primeiro];
        primeiro = (primeiro + 1) % array.length;
        return resp;
    }

    public boolean isCheia(){
        if((ultimo + 1)% array.length == primeiro){
            return true;
        }else{
            return false;
        }
    }

    public boolean isVazia(){
        if(ultimo == primeiro){
            return true;
        }else{
            return false;
        }
    }
}