import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class ABB<K, V> implements IMapeamento<K, V>{

	private No<K, V> raiz; // referência à raiz da árvore.
	private Comparator<K> comparador; //comparador empregado para definir "menores" e "maiores".
	private int tamanho;
	
	/**
	 * Método auxiliar para inicialização da árvore binária de busca.
	 * 
	 * Este método define a raiz da árvore como {@code null} e seu tamanho como 0.
	 * Se o comparador fornecido for {@code null}, o comparador padrão de ordem natural
	 * será utilizado.
	 * 
	 * @param comparador o comparador para organizar os elementos da árvore.
	 */
	@SuppressWarnings("unchecked")
	private void init(Comparator<K> comparador) {
		raiz = null;
		tamanho = 0;
		if (comparador == null) {
			comparador = (Comparator<K>) Comparator.naturalOrder();
		}
		this.comparador = comparador;
	}
	
	/**
     * Construtor da classe.
     * Esse construtor cria uma nova árvore binária de busca vazia. Para isso, esse método atribui null à raiz da árvore.
     */
    public ABB() {
        init(null);
    }

    /**
     * Construtor da classe.
     * Esse construtor cria uma nova árvore binária de busca vazia utilizando o
     * comparador fornecido para definir a organização dos elementos na árvore.
     * Para isso, esse método atribui null à raiz da árvore.
     *  
     * @param comparador o comparador a ser utilizado para organizar os elementos da árvore.  
     */
    public ABB(Comparator<K> comparador) {
        init(comparador);
    }
    
    /**
     * Construtor da classe.
     * Esse construtor cria uma nova árvore binária a partir de uma outra árvore binária de busca,
     * com os mesmos itens, mas usando uma nova chave.
     * @param original a árvore binária de busca original.
     * @param funcaoChave a função que irá extrair a nova chave de cada item para a nova árvore.
     */
    public ABB(ABB<?,V> original, Function<V,K> funcaoChave) {
        ABB<K,V> nova = new ABB<>();
        nova = copiarArvore(original.raiz, funcaoChave, nova);
        this.raiz = nova.raiz;
    }
    
    /**
     * Recursivamente, copia os elementos da árvore original para esta, num processo análogo ao caminhamento em ordem.
     * @param <T> Tipo da nova chave.
     * @param raizArvore raiz da árvore original que será copiada.
     * @param funcaoChave função extratora da nova chave para cada item da árvore.
     * @param novaArvore Nova árvore. Parâmetro usado para permitir o retorno da recursividade.
     * @return A nova árvore com os itens copiados e usando a chave indicada pela função extratora.
     */
    private <T> ABB<T,V> copiarArvore(No<?,V> raizArvore, Function<V,T> funcaoChave, ABB<T,V> novaArvore) {
    	
        if (raizArvore != null) {
    		novaArvore = copiarArvore(raizArvore.getEsquerda(), funcaoChave, novaArvore);
            V item = raizArvore.getItem();
            T chave = funcaoChave.apply(item);
    		novaArvore.inserir(chave, item);
    		novaArvore = copiarArvore(raizArvore.getDireita(), funcaoChave, novaArvore);
    	}
        return novaArvore;
    }

    /**
     * Método booleano que indica se a árvore está vazia ou não.
     * @return
     * verdadeiro: se a raiz da árvore for null, o que significa que a árvore está vazia.
     * falso: se a raiz da árvore não for null, o que significa que a árvore não está vazia.
     */
    public Boolean vazia() {
        return (this.raiz == null);
    }
    
    @Override
    /**
     * Método que encapsula a pesquisa recursiva de itens na árvore.
     * @param chave a chave do item que será pesquisado na árvore.
     * @return o valor associado à chave.
     */
	public V pesquisar(K chave) {	
    	return pesquisar(raiz, chave);
    }
    
    private V pesquisar(No<K, V> raizArvore, K procurado) {
    	
    	int comparacao;
    	
    	if (raizArvore == null)
    		/// Se a raiz da árvore ou sub-árvore for null, a árvore/sub-árvore está vazia e então o item não foi encontrado.
    		throw new NoSuchElementException("O item não foi localizado na árvore!");
    	
    	comparacao = comparador.compare(procurado, raizArvore.getChave());
    	
    	if (comparacao == 0)
    		/// O item procurado foi encontrado.
    		return raizArvore.getItem();
    	else if (comparacao < 0)
    		/// Se o item procurado for menor do que o item armazenado na raiz da árvore:
            /// pesquise esse item na sub-árvore esquerda.    
    		return pesquisar(raizArvore.getEsquerda(), procurado);
    	else
    		/// Se o item procurado for maior do que o item armazenado na raiz da árvore:
            /// pesquise esse item na sub-árvore direita.
    		return pesquisar(raizArvore.getDireita(), procurado);
    }
    
    @Override
    /**
     * Método que encapsula a adição recursiva de itens à árvore, associando-o à chave fornecida.
     * @param chave a chave associada ao item que será inserido na árvore.
     * @param item o item que será inserido na árvore.
     * 
     * @return o tamanho atualizado da árvore após a execução da operação de inserção.
     */
	public int inserir(K chave, V item) {
    	this.inserir(this.raiz, chave, item);
        return 0;
	}
    
    /**
     * Método recursivo responsável por adicionar um item à árvore.
     * @param raizArvore a raiz da árvore ou sub-árvore em que o item será adicionado.
     * @param chave a chave associada ao item que deverá ser inserido.
     * @param item o item que deverá ser adicionado à árvore.
     * @return a raiz atualizada da árvore ou sub-árvore em que o item foi adicionado.
     * @throws RuntimeException se um item com a mesma chave já estiver presente na árvore.
     */

    protected No<K, V> remover(K chave, No<K, V> i) throws Exception{
        if(i == null){
            throw new Exception("Erro");
        }
        int comp = comparador.compare(chave, i.getChave());

        if(comp < 0){
            i.setEsquerda(remover(chave, i));
        }else if(comp > 0){
            i.setDireita(remover(chave, i));
        }else if(i.getDireita() == null){
            i = i.getEsquerda();
        }else if(i.getEsquerda() == null){
            i = i.getDireita();
        }else{
            i.setEsquerda(anterior(i, i.getEsquerda()));
        }
        return i;
    }

    private No<K, V> anterior(No<K,V> i, No<K,V> j){
        if(j.getDireita() != null){
            j.setDireita(j.getDireita());
        }else{
            i = j;
            j = j.getEsquerda();
        }
        return j;
    }

    protected No<K, V> inserir(No<K, V> raizArvore, K chave, V item) {

        No<K, V> novo = new No<K,V>(chave, item);
    
        if(raizArvore == null){
            raizArvore = novo;
            return raizArvore;
        }


        if(raizArvore.getChave() == chave){
            throw new RuntimeException("as chaves não podem ser iguais");
        }


        No<K, V> atual = raizArvore;
            int comp = comparador.compare(chave, atual.getChave());

                if(comp < 0){
                    if(atual.getEsquerda() == null){
                        atual.setEsquerda(atual);

                    }
                    atual = atual.getEsquerda();
                }else{
                    if(atual.getDireita() == null){
                        atual.setDireita(atual);
                    }
                    atual = atual.getDireita();
            }
            return atual;           
    }

    @Override 
    public String toString(){
    	// TODO
    	return "";
    }

    @Override
	public String percorrer() {
    	// TODO
		return "";
	}
    
	@Override
	/**
     * Método que encapsula a remoção recursiva de um item da árvore.
     * @param chave a chave do item que deverá ser localizado e removido da árvore.
     * @return o valor associado ao item removido.
	 */
    

	public V remover(K chave) throws Exception{
        raiz = remover(chave, raiz);
		return raiz.getItem();
	}

	@Override
	public int tamanho() {
		return tamanho;
	}
	
	@Override
	public long getComparacoes() {
		// TODO
		return 0;
	}

	@Override
	public double getTempo() {
		// TODO
		return 0.0;
	}
}