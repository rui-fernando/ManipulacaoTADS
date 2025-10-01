package tad.listasEncadeadas;

import tad.util.Conversor;

public class ListaEncadeadaImpl <T extends Comparable<T>> implements ListaEncadeadaIF<T> {
	
	NodoListaEncadeada<T> cabeca = null;
	NodoListaEncadeada<T> cauda = null;
	int tamanho;
	
	public ListaEncadeadaImpl() {
		cabeca = new NodoListaEncadeada<T>();
		cauda = new NodoListaEncadeada<T>();
		cabeca.setProximo(cauda);
		tamanho = 0;;
	}
	
	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	@Override
	public int size() {
		return tamanho;
	}
	
	@Override
	public NodoListaEncadeada<T> search(T chave) {
	    NodoListaEncadeada<T> atual = cabeca.getProximo();

	    while (atual != null && atual != cauda) {
	        T atualChave = atual.getChave();

	        if (chave == null) {
	            if (atualChave == null) return atual;
	        } else {
	            if (atualChave != null && atualChave.equals(chave)) return atual;
	        }

	        atual = atual.getProximo();
	    }

	    return null;
	}
	
	@Override
	public void insert(T chave) {
		
		// criar o novo nó
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
		NodoListaEncadeada<T> atual = cabeca;
		
		while (atual.getProximo() != cauda) {
			atual = atual.getProximo();
		}
		
		atual.setProximo(novoNo);
		novoNo.setProximo(cauda);
		tamanho++;
		
		/*
		// inseri-lo na lista
		
		if (cabeca.getProximo().equals(cauda)) { //se a lista estiver vazia
			cabeca.setProximo(novoNo);
			novoNo.setProximo(cauda);
		
		} else {// lista não está vazia
			novoNo.setProximo(cabeca.getProximo());
			cabeca.setProximo(novoNo);	
		}
		
		tamanho++;
		*/
	}
	
	@Override
	public NodoListaEncadeada<T> remove(T chave) throws ListaVaziaException {
		
		if (isEmpty()) {
			throw new ListaVaziaException("A lista está vazia. "
					+ "Não é possível remover elementos.");
		}
		
		NodoListaEncadeada<T> noAnterior = cabeca;
		NodoListaEncadeada<T> noAtual = cabeca.getProximo();
		
		while (noAnterior != cauda) {
			
			if (noAtual.getChave().equals(chave)) {
				noAnterior.setProximo(noAtual.getProximo());
				tamanho--;
				return noAtual;
			}
			
			noAnterior = noAtual;
			noAtual = noAtual.getProximo();
		}
		return null;
	}
	
	@Override
	public T[] toArray(Class<T> clazz) {
		// Criar um array usando a classe utilitária conversor
		Conversor<T> c = new Conversor<T>();
		T[] meuArray = c.gerarArray(clazz, this.size());
		
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		int cont = 0;
		while (atual != cauda) {
			meuArray[cont] = atual.getChave();
			atual = atual.getProximo();
			cont++;
		}
		
		return meuArray;
	}
	
	@Override
	public String imprimeEmOrdem() {
		
		if (isEmpty()) {return "";}
		String valores = "";
		
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		
	    while (corrente != null && corrente != cauda) {
	        if (corrente.getChave() != null) {
	            valores += corrente.getChave();
	            if (corrente.getProximo() != null && corrente.getProximo() != cauda && corrente.getProximo().getChave() != null) {
	                valores += ", ";
	            }
	        }
	        corrente = corrente.getProximo();
	    }

		
		return valores;
	}
	
	@Override
	public String imprimeInverso() {
		return imprimeInversoAux(cabeca.getProximo());
	}

	private String imprimeInversoAux(NodoListaEncadeada<T> no) {
		
		if (no == null || no.equals(cauda)) {
			return "";
		}
		String resto = imprimeInversoAux(no.getProximo());
		
		if (no.getChave() == null) {
			return resto;
		}
	    return resto.isEmpty() ? no.getChave().toString() : resto + ", " + no.getChave();

	}
	
	@Override
	public NodoListaEncadeada<T> sucessor(T chave){
		
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		
		while (atual != cauda) {
			if (atual.getChave().equals(chave)) {
				
				return atual.getProximo() != cauda ? atual.getProximo() : null;
			}
			
			atual = atual.getProximo();
		}
		
		return null;
	}
	
	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		
		NodoListaEncadeada<T> anterior = cabeca;
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		
		while(atual != null && atual != cauda) {
			T atualChave = atual.getChave();
			if (atualChave != null && atual.getChave().equals(chave)) {
				return anterior == cabeca ? null : anterior;
			}
			
			anterior = atual;
			atual = atual.getProximo();
		}
		
		return null;
	}

	@Override
	public void insert(T chave, int index) {
        
		if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        NodoListaEncadeada<T> novo = new NodoListaEncadeada<>(chave);
        NodoListaEncadeada<T> atual = cabeca;

        for (int i = 0; i < index; i++) {
            atual = atual.getProximo();
        }
        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        tamanho++;
	}
	
	
	
}
