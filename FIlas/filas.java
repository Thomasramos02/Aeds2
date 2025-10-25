package FIlas;

public class filas {
    Celula primeiro;
    Celula ultimo;

    public filas(Celula primeiro, Celula ultimo){
        this.primeiro = new Celula();
        this.ultimo = primeiro;
    }

    public void inserir(int x){
        ultimo.setProx(new Celula(x, null));
        ultimo = ultimo.getProx();
    }

    public void remover() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Fila vazia");
        }else{
            Celula tmp = primeiro;
            primeiro = primeiro.getProx();
            int elemento = tmp.getElemento();
            tmp.setProx(null);
            tmp = null;
            System.out.println("Elemento removido: "+ elemento);
        }
    }

    public int consultarUltimo() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Fila vazia");
        }else{
            return ultimo.getElemento();
        }
    }

    public void consultar() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Fila vazia");
        }else{
            for(Celula i = primeiro.getProx(); i != null; i =i.getProx()){
                System.out.println(i.getElemento());
            }
        }
    }
}
