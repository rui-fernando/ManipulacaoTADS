package tad.listasEncadeadas;

import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;

public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {

	private ListaEncadeadaIF<Integer> fila;
	
	public FilaListaEncadeada() {
		fila = new ListaEncadeadaImpl<>();
	}
	
	@Override
	public void enfileirar(NodoListaEncadeada<Integer> item)
			throws FilaCheiaException {
		fila.insert(item.getChave());
		
	}

	@Override
	public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
	
		if (fila.isEmpty()) {
			throw new FilaVaziaException();
		}
		
		NodoListaEncadeada<Integer> primeiro = fila.sucessor(null);
		
		if (primeiro == null) {
			throw new FilaVaziaException();
		}
		
		try {
			fila.remove(primeiro.getChave());
		} catch (ListaVaziaException e) {
			System.out.println("Lista vazia.");
		}
		return primeiro;
	}

	@Override
	public NodoListaEncadeada<Integer> verificarCauda() {
        if (fila.isEmpty()) {
            return null;
        }
        // Percorrer até o penúltimo elemento, pois cauda é sentinela
        NodoListaEncadeada<Integer> atual = fila.search(null).getProximo();
        NodoListaEncadeada<Integer> anterior = null;
        while (atual != null && !atual.isNull()) {
            anterior = atual;
            atual = atual.getProximo();
        }
        return anterior;
	}

	@Override
	public NodoListaEncadeada<Integer> verificarCabeca() {
        if (fila.isEmpty()) {
            return null;
        }
        // O primeiro nó após a cabeça sentinela
        NodoListaEncadeada<Integer> primeiro = fila.search(null).getProximo();
        return (primeiro != null && !primeiro.isNull()) ? primeiro : null;
	}

	@Override
	public boolean isEmpty() {
		return fila.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}
}
