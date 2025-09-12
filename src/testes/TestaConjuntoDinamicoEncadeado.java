package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tad.conjuntoDinamico.ConjuntoDinamicoIF;
import tad.conjuntoDinamico.MeuConjuntoDinamicoEncadeado;

public class TestaConjuntoDinamicoEncadeado {

	private ConjuntoDinamicoIF<Integer> cd = null;
	
	@BeforeEach
	public void setUp() {
		cd = new MeuConjuntoDinamicoEncadeado();
	}
	
	@Test
	public void inserirTest() {
		assertEquals(0, cd.tamanho());
		
		cd.inserir(10);
		assertEquals(1, cd.tamanho());
		
		cd.inserir(1);
		assertEquals(2, cd.tamanho());
		
		cd.inserir(3);
		assertEquals(3, cd.tamanho());
		
		cd.inserir(4);
		assertEquals(4, cd.tamanho());
		
		cd.inserir(6);
		assertEquals(5, cd.tamanho());
		
		cd.inserir(3);
		assertEquals(6, cd.tamanho());
		
		cd.inserir(1);
		assertEquals(7, cd.tamanho());
		
		cd.inserir(6);
		assertEquals(8, cd.tamanho());
	}
	
	/*@Test
	public void inserirFinalTest() {
		
		assertEquals(0, cd.tamanho());
		
		cd.inserirFinal(2);
		
	}*/
	
	@Test
	public void tamanhoTest() {
		assertEquals(0, cd.tamanho());
		
		cd.inserir(8);
		assertEquals(1, cd.tamanho());
		
		cd.inserir(10);
		assertEquals(2, cd.tamanho());
		
		cd.inserir(3);
		assertEquals(3, cd.tamanho());
		
		cd.inserir(8);
		assertEquals(4, cd.tamanho());
		
		cd.inserir(5);
		assertEquals(5, cd.tamanho());
		
		cd.inserir(0);
		assertEquals(6, cd.tamanho());
		
		cd.inserir(9);
		assertEquals(7, cd.tamanho());
		
		cd.inserir(12);
		assertEquals(8, cd.tamanho());
	}
	
	@Test
	public void buscarTest() {
		
		for (int i = 0; i < 15; i++) {
			cd.inserir(i);
		}
		
		assertEquals(12, cd.buscar(12));
	}
	
	@Test
	public void buscarTestFail() throws Exception {
		
		for (int i = 0; i < 15; i++) {
			cd.inserir(i);
		}
		
		assertNull(cd.buscar(123), "Deveria lançar exceção ao tentar buscar por valor inexistente.");
	}
	
	@Test
	public void buscarTestFail2() {
		assertNull(cd.buscar(8), "Deveria lançar exceção ao tentar buscar valor em CDE vazio");
	}
	
	@Test
	public void predecessorTest() throws Exception {
		
		cd.inserir(1);
		cd.inserir(5);
		cd.inserir(9);
		cd.inserir(6);
		cd.inserir(11);
		cd.inserir(0);
		cd.inserir(10);
		
		assertNull(cd.predecessor(10));
		assertEquals(10, cd.predecessor(0));
		assertEquals(0, cd.predecessor(11));
		assertEquals(11, cd.predecessor(6));
		assertNull(cd.predecessor(300));
		
	}
	
	@Test
	public void removerTest() throws Exception {
		assertEquals(0, cd.tamanho());
		cd.inserir(2);
		cd.inserir(2);
		cd.inserir(1);
		cd.inserir(5);
		assertEquals(2, cd.remover(2));
		assertEquals(3, cd.tamanho());
		
		assertEquals(1, cd.remover(1));
		assertEquals(2, cd.tamanho());
		
		assertEquals(5, cd.remover(5));
		assertEquals(1, cd.tamanho());
		
		assertEquals(2, cd.remover(2));
		assertEquals(0, cd.tamanho());
	}

}
