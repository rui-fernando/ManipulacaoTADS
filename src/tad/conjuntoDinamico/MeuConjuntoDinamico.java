package tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {

	private Integer[] meusDados = null;
	private int posInsercao = 0;
	
	@Override
	public void inserir(Integer item) {
		
		//se o array estiver vazio ou o tamanho for igual a 0
		//cria um array de pelo menos 1 tamanho
		
		if (meusDados == null) {
			System.out.println("Criando array de tamanho 1");
			meusDados = new Integer[1];
			posInsercao = 0;
		}
		
		if (arrayEstaCheio()) {
			meusDados = aumentarArray();
		}
		meusDados[posInsercao++] = item;
		
	    System.out.println("Item " + item + " inserido na posição " + (posInsercao - 1));
	}
	
	private boolean arrayEstaCheio() {
		return posInsercao >= meusDados.length;
	}

	private Integer[] aumentarArray() {
		// criar um array maior (arrayMaior)
		// Qual é a taxa de aumento desse array?
		// copiar os dados de meusDados (array cheio)
		// colar os dados para o novo array (arrayMaior)
		if (meusDados == null || meusDados.length == 0) { //verifica se o array tem pelo menos tamanho 1, pois não daria para aumentar um array de tamanho 0.
			
			System.out.println("O array está vazio, pois deveria ter pelo menos tamanho 1");
			return new Integer[1];
		}
		
		int tamanhoNovo = (int) Math.floor(meusDados.length * 2); //array tem taxa de 100% maior em relação ao anterior
		
		Integer[] arrayMaior = new Integer[tamanhoNovo]; // cria um array maior com tamanho de 100% a mais que original.
		
		System.arraycopy(meusDados, 0, arrayMaior, 0, posInsercao); //copia os dados do array antigo, preserva a ordem pré-estabelecida.
		
		System.out.println("\n Array aumentou de tamanho: " + tamanhoNovo);
		return arrayMaior;

	}
	
	@Override
	public Integer remover(Integer item) throws Exception {
		
	    Integer idx = indiceDoItem(item);
	    if (idx == null) {
	        System.out.println("O item " + item + " não foi encontrado neste array.");
	        return null;
	    }
	    
	    if (posInsercao == 0) {
	    	System.out.println("O array está vazio, não é possível remover elementos.");
	    	return null;
	    }

	    Integer removido = meusDados[idx];

	    for (int i = idx; i < posInsercao - 1; i++) {
	        meusDados[i] = meusDados[i + 1];
	    }

	    meusDados[posInsercao - 1] = null;
	    posInsercao--;

	    System.out.println("Item " + removido + " removido.");

	    return removido;

	}
	
	@Override
	public Integer predecessor(Integer item) throws Exception {
	    if (posInsercao == 0 || item == null) {
	        throw new Exception("Conjunto vazio ou item nulo");
	    }

	    for (int i = 1; i < posInsercao; i++) { // começa em 1 para evitar i - 1 < 0
	        if (meusDados[i] != null && meusDados[i].equals(item)) {
	            return meusDados[i - 1]; 
	        }
	    }

	    return null; // item não encontrado ou está na primeira posição
	}

	@Override
	public Integer sucessor(Integer item) throws Exception {
	    if (posInsercao == 0 || item == null) {
	        throw new Exception("Conjunto vazio ou item nulo");
	    }

	    for (int i = 0; i < posInsercao - 1; i++) {
	        if (meusDados[i] != null && meusDados[i].equals(item)) {
	            return meusDados[i + 1]; // Retorna o próximo elemento
	        }
	    }

	    // Se o item estiver na última posição ou não for encontrado
	    return null;
	}
	@Override
	public int tamanho() {
		return posInsercao;
	}

	@Override
	public Integer buscar(Integer item) {
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] != null && meusDados[i].equals(item)) {
				return meusDados[i];
			}
		}
		return null;
	}

	@Override
	public Integer minimum() throws Exception {
		
		if (posInsercao == 0) {
			throw new Exception("O array está vazio");
		}
		
		Integer menor = null;
		for (int i = 0;  i <  posInsercao; i++) {
			Integer valor = meusDados[i];
			if (valor != null && (menor == null || valor < menor)) {
				menor = valor;
			}
		}
		
		return menor;
	}

	@Override
	public Integer maximum() throws Exception {
		if (posInsercao == 0) {
			throw new Exception("O array está vazio.");
		}
		
		Integer maior = null;
		for (int i = 0; i < posInsercao; i++) {
		    Integer valor = meusDados[i];
		    if (valor != null && (maior == null || valor > maior)) {
		        maior = valor;
		    }
		}

		
		return maior;
	}

	private Integer indiceDoItem(Integer item) {
	    for (int i = 0; i < posInsercao; i++) {
	        if (meusDados[i] != null && meusDados[i].equals(item)) {
	            return i;
	        }
	    }
	    return null;
	}


}
