package tad.fila;

public class MinhaFila implements FilaIF<Integer>{

	private int tamanho = 10;
	private int cauda = 0;
	private int cabeca = 0;
	
	private Integer[] meusDados = null;
	
	public MinhaFila(int tamanhoInicial) {
		this.tamanho = tamanhoInicial + 1;
		meusDados = new Integer[tamanho];
	}
	
	public MinhaFila() {
		meusDados = new Integer[tamanho];
	}
	
	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		
		if (isFull()) {
			throw new FilaCheiaException();
		}
		
		meusDados[cauda++] = item;
		cauda = (cauda) % tamanho;
	}
	
	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		
		Integer item = meusDados[cabeca];
		meusDados[cabeca] = null;
		cabeca = (cabeca + 1) % tamanho;
		
		return item;
	}
	
	@Override
	public Integer verificarCauda() {
        int pos = (cauda - 1 + tamanho) % tamanho;
        return meusDados[pos];
	}

	@Override
	public Integer verificarCabeca() {
		return meusDados[cabeca];
	}

	@Override
	public boolean isEmpty() {
		return cabeca == cauda;
	}

	@Override
	public boolean isFull() {
		return (cauda + 1) % tamanho == cabeca; //fila suporta tamanho - 1
	}

}
