package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tad.pilha.*;

public class TestaPilha {

	protected PilhaIF<Integer> pilha;
	
	@BeforeEach
	public void setUp() {
		pilha = new MinhaPilha();
	}
	
	@Test
	public void empilharTest() {
		try {
			pilha.empilhar(3);
		
			assertEquals(3, pilha.topo());
			pilha.empilhar(5);
			assertEquals(5, pilha.topo());
			pilha.empilhar(7);
			assertEquals(7, pilha.topo());
			pilha.empilhar(4);
			assertEquals(4, pilha.topo());
			pilha.empilhar(2);
			assertEquals(2, pilha.topo());
		} catch (PilhaCheiaException e) {
			fail("empilharTest está estourando a pilha erroneamente");
		}
	}
	
	@Test
	public void topoTest() {
		System.out.println(pilha.topo());
		assertNull(pilha.topo());
		try {
			pilha.empilhar(3);
			assertEquals(3, pilha.topo());
			pilha.empilhar(5);
			assertEquals(5, pilha.topo());
			pilha.empilhar(7);
			assertEquals(7, pilha.topo());
			pilha.empilhar(4);
			assertEquals(4, pilha.topo());
			pilha.empilhar(2);
			assertEquals(2, pilha.topo());
		} catch (PilhaCheiaException e) {
			fail(" está estourando a pilha erroneamente");
		}
		
	}
	
	@Test
	public void desempilharTest() {
		try {
			pilha.desempilhar();
			fail("deveria lançar uma exceção quando chamar o desempilhar de uma pilha vazia");
		} catch (Exception e) {}
		try {
			pilha.empilhar(3);
			assertEquals(3, pilha.topo());
			pilha.empilhar(5);
			assertEquals(5, pilha.topo());
			pilha.empilhar(7);
			assertEquals(7, pilha.topo());
			pilha.empilhar(4);
			assertEquals(4, pilha.topo());
			pilha.empilhar(2);
		} catch (PilhaCheiaException e) {
			fail(" está estourando a pilha erroneamente");
		} 
		try {
			assertEquals(2, pilha.topo());
			assertEquals(2, pilha.desempilhar());
			assertEquals(4, pilha.topo());
			
			assertEquals(4, pilha.desempilhar());
			assertEquals(7, pilha.topo());
			
			assertEquals(7, pilha.desempilhar());
			assertEquals(5, pilha.topo());
			
			assertEquals(5, pilha.desempilhar());
			assertEquals(3, pilha.topo());
			
			assertEquals(3, pilha.topo());
		} catch (PilhaVaziaException e) {
			fail(" está esvaziando a pilha erroneamente");
		}
	}

	@Test
	public void isEmptyTest() {
		assertTrue(pilha.isEmpty());
		try { 
			pilha.empilhar(3);
			assertEquals(3, pilha.topo());
			assertFalse(pilha.isEmpty());
			pilha.desempilhar();
			assertTrue(pilha.isEmpty());
			pilha.empilhar(4);
			pilha.empilhar(6);
			assertFalse(pilha.isEmpty());
		} catch (PilhaCheiaException e) {
			fail(" está estourando a pilha erroneamente");
		} catch (PilhaVaziaException e) {
			fail(" está esvaziando a pilha erroneamente");
		}
	}
	
	
	@Test
	public void pilhaVaziaTest() {
		assertThrows(PilhaVaziaException.class, () -> {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.desempilhar();
			pilha.desempilhar();
			pilha.desempilhar();
			pilha.desempilhar();
	    });
	}
	
	@Test
	public void pilhaCheiaTest() {
		pilha = new MinhaPilha(5);
		assertThrows(PilhaCheiaException.class, () -> {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
	    });
	}
	
	@Test
	public void multitopTest() {
	    try {
	        pilha.empilhar(3);
	        pilha.empilhar(2);
	        pilha.empilhar(10);
	        pilha.empilhar(3);

	        // multitop(3) deve retornar: 3, 10, 2
	        PilhaIF<Integer> resultado3 = pilha.multitop(3);
	        assertEquals(3, resultado3.desempilhar());
	        assertEquals(10, resultado3.desempilhar());
	        assertEquals(2, resultado3.desempilhar());

	        // multitop(5) deve retornar: 3, 10, 2, 3
	        PilhaIF<Integer> resultado5 = pilha.multitop(4);
	        assertEquals(3, resultado5.desempilhar());
	        assertEquals(10, resultado5.desempilhar());
	        assertEquals(2, resultado5.desempilhar());
	        assertEquals(3, resultado5.desempilhar());

	        // multitop(10) deve lançar exceção
	        assertThrows(IllegalArgumentException.class, () -> {
	            pilha.multitop(10);
	        });

	    } catch (PilhaCheiaException | PilhaVaziaException e) {
	        fail("Exceção inesperada: " + e.getMessage());
	    }
	}
}
