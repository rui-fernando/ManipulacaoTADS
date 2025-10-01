package tad.fila;

public class MinhaFilaEncadeada implements FilaIF<Integer>{

	private class No {
		Integer valor;
		No proximo;
		
		No (Integer valor){
			this.valor = valor;
			this.proximo = null;
		}
	}
	
	private No cabeca;
	private No cauda;
	
	public MinhaFilaEncadeada() {
		this.cabeca = null;
		this.cauda = null;
	}
	
	
	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		
		No noNovo = new No(item);
		
		if (isEmpty()) {
			cabeca = noNovo;
			cauda = noNovo;
		} else {
			cauda.proximo = noNovo;
			cauda = noNovo;
		}
		
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		
		Integer valorRetirado = cabeca.valor;
		cabeca = cabeca.proximo;
		
		if (cabeca == null) {
			cauda = null;
		}
		
		return valorRetirado;
	}

	@Override
	public Integer verificarCauda() {
		
		if (isEmpty()) {
			return null;
		}
		return cauda.valor;
	}

	@Override
	public Integer verificarCabeca() {
		
		if (isEmpty()) {
			return null;
		}
		return cabeca.valor;
	}

	@Override
	public boolean isEmpty() {
		
		return cabeca == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
