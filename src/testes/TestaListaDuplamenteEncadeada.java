package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import tad.listasEncadeadas.*;

public class TestaListaDuplamenteEncadeada {
	
	private ListaDuplamenteEncadeadaIF<Integer> listaDuplaEnc = null;
	
	@BeforeEach
	public void setUp() {
		listaDuplaEnc = new ListaDuplamenteEncadeadaImpl<Integer>();
	}
	
	@Test
	public void imprimeEmOrdemTest() {
		assertEquals("", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(2);
		assertEquals("2", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {2}, listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(10);
		assertEquals("2, 10", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(5);
		assertEquals("2, 10, 5", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(9);
		assertEquals("2, 10, 5, 9", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(1);
		assertEquals("2, 10, 5, 9, 1", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(3);
		assertEquals("2, 10, 5, 9, 1, 3", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(4);
		assertEquals("2, 10, 5, 9, 1, 3, 4", listaDuplaEnc.imprimeEmOrdem());
	}

}
