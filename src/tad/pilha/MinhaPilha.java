package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer>{

	private int tamanho = 10;
	private Integer[] meusDados = null;
	private int topo = -1;
	
	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		this.meusDados = new Integer[tamanho];
	}
	
	public MinhaPilha() {
		this.meusDados = new Integer[this.tamanho];
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		
		if (topo == tamanho - 1) {
			throw new PilhaCheiaException();
		}
		topo++;
		meusDados[topo] = item;
		
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		
		Integer item = meusDados[topo];
		meusDados[topo] = null;
		topo--;
		return item; 
	}
	
	@Override
	public Integer topo() {
		
		if (isEmpty()) return null;
		
		return meusDados[topo];
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
	    if (k < 0 || k > (topo + 1)) {
	        throw new IllegalArgumentException("Quantidade inválida de elementos para multitop");
	    }

	    MinhaPilha novaPilha = new MinhaPilha(k);
	    for (int i = topo - k + 1; i <= topo; i++) {
	        try {
	            novaPilha.empilhar(meusDados[i]);
	        } catch (PilhaCheiaException e) {
	            throw new RuntimeException("Erro ao copiar elementos para a nova pilha", e);
	        }
	    }
	    return novaPilha;
	}

	@Override
	public boolean isEmpty() {
		return topo == -1;
	}
}
