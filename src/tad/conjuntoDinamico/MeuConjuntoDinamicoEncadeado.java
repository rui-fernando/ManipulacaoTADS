package tad.conjuntoDinamico;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

	
    private class No {
    	Integer valor;
    	No proximo;
    	
    	No (Integer valor){
    		this.valor = valor;
    		this.proximo = null;
    	}
    }
    
    private No inicio;
    private int tamanho;
    
    public MeuConjuntoDinamicoEncadeado() {
    	this.inicio = null;
    	this.tamanho = 0;
    }
    
    
    @Override
    public void inserir(Integer item) {
    	
    	No novoNo = new No(item);
    	novoNo.proximo = inicio;
    	inicio = novoNo;
    	tamanho++;
    		
    }
    
    /*@Override
    public void inserir(Integer item) {
    	
    	No novoNo = new No(item);
    	
    	if (inicio == null) {
    		inicio = novoNo;
    	} else {
    		No atual = inicio;
    		while (atual.proximo != null) {
    			atual = atual.proximo;
    		}
    		atual.proximo = novoNo;
    	}
    	tamanho++;
    }*/

    @Override
    public Integer remover(Integer item) throws Exception {
    	
    	if (inicio == null || item == null) {
    		throw new Exception("Conjunto vazio ou item nulo.");
    	}
    	
    	No atual = inicio;
        No anterior = null;
    	
    	while (atual != null) {
    		if (atual.valor.equals(item)) {
    			if (anterior == null) {
    				inicio = atual.proximo;
    			} else {
    				anterior.proximo = atual.proximo;
    			}
    			
    			tamanho--;
    			return atual.valor;
    		}
    		anterior = atual;
    		atual = atual.proximo;
    	}
    	
    	return null;
    }

    @Override
    public Integer predecessor(Integer item) throws Exception {
    	
    	if (inicio == null || item == null) {
    		throw new Exception("Conjunto vazio ou item nulo");
    	}
    	
    	No atual = inicio;
    	No anterior = null;

    	while (atual != null) {
    		
    		if (atual.valor.equals(item)) {
    			return (anterior != null) ? anterior.valor : null;
    		}
    		
    		anterior = atual;
    		atual = atual.proximo;
    	}
    	
    	return null;
    }

    @Override
    public Integer sucessor(Integer item) {

        No atual = inicio;

        while (atual != null) {
            if (atual.valor.equals(item)) {
                return (atual.proximo != null) ? atual.proximo.valor : null;
            }
            atual = atual.proximo;
        }
        return null;
    }

    @Override
    public int tamanho() {
    	return tamanho;
    }

    @Override
    public Integer buscar(Integer item) {
    	
    	No atual = inicio;
    	while (atual != null) {
    		if (atual.valor.equals(item)) {
    			return atual.valor;
    		}
    		atual = atual.proximo;
    	}
    	
    	return null;
    }

    @Override
    public Integer minimum() {
    	
    	if (inicio == null) {
    		return null;
    	}
    	
    	No atual = inicio;
    	Integer menor = atual.valor;
    	
    	while (atual != null) {
    		if (atual.valor < menor) {
    			menor = atual.valor;
    		}
    		atual = atual.proximo;
    	}
    	
    	return menor;
    }

    @Override
    public Integer maximum() {
    	
    	if (inicio == null) {
    		return null;
    	}
    	
    	No atual = inicio;
    	Integer maior = atual.valor; 
    	
    	while (atual != null) {
    		if (atual.valor > maior) {
    			maior = atual.valor;
    		}
    		atual = atual.proximo;
    	}
    	
    	return maior;
    }
}
