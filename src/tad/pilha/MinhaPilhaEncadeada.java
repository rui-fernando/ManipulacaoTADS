package tad.pilha;

import tad.listasEncadeadas.ListaEncadeadaIF;
import tad.listasEncadeadas.ListaEncadeadaImpl;
import tad.listasEncadeadas.ListaVaziaException;

public class MinhaPilhaEncadeada implements PilhaIF<Integer> {

	private ListaEncadeadaIF<Integer> listaEnc = new ListaEncadeadaImpl<>();
	
	@Override
	public void empilhar(Integer item) {
		listaEnc.insert(item);
	}
	
	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (listaEnc.isEmpty()) {
			throw new PilhaVaziaException();
		}
		
		// o elemento no topo é o primeiro da lista (LIFO)
		//remove o primeiro elemento inserido
		
        Integer topo = listaEnc.toArray(Integer.class)[0];
        try {
			listaEnc.remove(topo);
		} catch (ListaVaziaException e) {
			System.out.println("Lista vazia.");
		}
        return topo;
	}
	
	@Override
	public Integer topo() {
		if (listaEnc.isEmpty()) return null;
		return listaEnc.toArray(Integer.class)[0];
	}
	
    @Override
    public PilhaIF<Integer> multitop(int k) {
        MinhaPilhaEncadeada novaPilha = new MinhaPilhaEncadeada();
        Integer[] elementos = listaEnc.toArray(Integer.class);
        
        for (int i = 0; i < k && i < elementos.length; i++) {
            novaPilha.empilhar(elementos[i]);
        }
        return novaPilha;
    }

    @Override
    public boolean isEmpty() {
        return listaEnc.isEmpty();
    }
}
