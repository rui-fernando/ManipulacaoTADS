package tad.listasEncadeadas;

import tad.util.Conversor;

public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {

    private NodoListaDuplamenteEncadeada<T> cabeca;
    private NodoListaDuplamenteEncadeada<T> cauda;
    private int tamanho;

    public ListaDuplamenteEncadeadaImpl() {
        cabeca = new NodoListaDuplamenteEncadeada<>();
        cauda = new NodoListaDuplamenteEncadeada<>();
        cabeca.setProximo(cauda);
        cauda.setAnterior(cabeca);
        tamanho = 0;
    }

    @Override
    public void inserePrimeiro(T elemento) {
        NodoListaDuplamenteEncadeada<T> novo = new NodoListaDuplamenteEncadeada<>(elemento);
        NodoListaDuplamenteEncadeada<T> primeiro = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();

        novo.setProximo(primeiro);
        novo.setAnterior(cabeca);
        cabeca.setProximo(novo);
        primeiro.setAnterior(novo);

        tamanho++;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> removeUltimo() {
        if (isEmpty()) {
            return null;
        }
        NodoListaDuplamenteEncadeada<T> ultimo = cauda.getAnterior();
        NodoListaDuplamenteEncadeada<T> penultimo = ultimo.getAnterior();

        penultimo.setProximo(cauda);
        cauda.setAnterior(penultimo);

        tamanho--;
        return ultimo;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
        if (isEmpty()) {
            return null;
        }
        NodoListaDuplamenteEncadeada<T> primeiro = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        NodoListaDuplamenteEncadeada<T> segundo = (NodoListaDuplamenteEncadeada<T>) primeiro.getProximo();

        cabeca.setProximo(segundo);
        segundo.setAnterior(cabeca);

        tamanho--;
        return primeiro;
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
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();

        while (atual != cauda) {
            if (atual.getChave().equals(chave)) {
                return atual;
            }
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return null;
    }

    @Override
    public void insert(T chave) {
        NodoListaDuplamenteEncadeada<T> novo = new NodoListaDuplamenteEncadeada<>(chave);
        NodoListaDuplamenteEncadeada<T> ultimo = cauda.getAnterior();

        novo.setProximo(cauda);
        novo.setAnterior(ultimo);
        ultimo.setProximo(novo);
        cauda.setAnterior(novo);

        tamanho++;
    }

    @Override
    public void insert(T chave, int index) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }

        NodoListaDuplamenteEncadeada<T> atual = cabeca;
        for (int i = 0; i < index; i++) {
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }

        NodoListaDuplamenteEncadeada<T> proximo = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        NodoListaDuplamenteEncadeada<T> novo = new NodoListaDuplamenteEncadeada<>(chave);

        novo.setProximo(proximo);
        novo.setAnterior(atual);
        atual.setProximo(novo);
        proximo.setAnterior(novo);

        tamanho++;
    }

    @Override
    public NodoListaEncadeada<T> remove(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();

        while (atual != cauda) {
            if (atual.getChave().equals(chave)) {
                NodoListaDuplamenteEncadeada<T> anterior = atual.getAnterior();
                NodoListaDuplamenteEncadeada<T> proximo = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();

                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);

                tamanho--;
                return atual;
            }
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return null;
    }

    @Override
    public String imprimeEmOrdem() {
    	if (isEmpty()) {return "";}
    	
    	String valores = "";
    	NodoListaDuplamenteEncadeada<T> corrente = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();

    	
    	while (corrente != null && corrente != cauda) {
    		if (corrente.getChave() != null) {
    			valores += corrente.getChave();
    			if (corrente.getProximo() != null &&
    			    corrente.getProximo() != cauda &&
    			    corrente.getProximo().getChave() != null) {
    				
    				valores += ", ";
    				
    			}
    		}
    		
    		corrente = (NodoListaDuplamenteEncadeada<T>) corrente.getProximo();
    	}
    	
    	return valores;
    }

    @Override
    public String imprimeInverso() {
        StringBuilder sb = new StringBuilder();
        NodoListaDuplamenteEncadeada<T> atual = cauda.getAnterior();

        while (atual != cabeca) {
            sb.append(atual.getChave()).append(" ");
            atual = atual.getAnterior();
        }

        return sb.toString().trim();
    }

    @Override
    public NodoListaEncadeada<T> sucessor(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();

        while (atual != cauda) {
            if (atual.getChave().equals(chave)) {
                return atual.getProximo() != cauda ? atual.getProximo() : null;
            }
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return null;
    }

    @Override
    public NodoListaEncadeada<T> predecessor(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();

        while (atual != cauda) {
            if (atual.getChave().equals(chave)) {
                return atual.getAnterior() != cabeca ? atual.getAnterior() : null;
            }
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return null;
    }

    @Override
    public T[] toArray(Class<T> clazz) {
        Conversor<T> conversor = new Conversor<>();
        T[] array = conversor.gerarArray(clazz, tamanho);

        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        int index = 0;

        while (atual != cauda) {
            array[index++] = atual.getChave();
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }

        return array;
    }
}