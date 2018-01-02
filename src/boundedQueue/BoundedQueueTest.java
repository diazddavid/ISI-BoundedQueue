package boundedQueue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BoundedQueueTest {
	
	BoundedQueue b;

	@Before
	public void setUp() throws Exception {
		b = new BoundedQueue(2);
	}
	
	// Test con capacidad negativa
	@Test(expected=IllegalArgumentException.class)
	public void testC1() {
		b = new BoundedQueue(-5);
	}
	
	// Test para happy path
	// Cubre T de C1, TT de {C2,C3}, T de C4 con deQueue, T de C4 con isEmpty y T de C3 con isFull
	@Test
	public void test2 () {
		b.enQueue((Object) 5);
		assertFalse("Fallo con isEmpty", b.isEmpty());
		assertFalse("Fallo con isFull", b.isFull());
		assertEquals("Fallo con deQueue", b.deQueue(), (Object) 5);
	}
	
	// Test de lista llena
	// Cubre TF de {C2, C3} en enQueue y F de C3 en isFull
	@Test(expected=IllegalStateException.class)
	public void test3 (){
		b.enQueue(1);
		b.enQueue(2);
		assertTrue("Fallo con isFull con lista llena", b.isFull());
		b.enQueue(3);
	}

	// Test cola vacia
	// Cubre F de {C4} en deQueue y F de C4 en isEmpty
	@Test(expected=IllegalStateException.class)
	public void test4 () {
		b.deQueue();
		assertTrue("Fallo con isEmpty", b.isEmpty());
	}
	
}
