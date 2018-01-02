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
	
	// Test para lista llena
	// Cubre T de C1, TT de {C2,C3}, T de C4 con deQueue, T de C4 con isEmpty y T de C3 con isFull
	@Test
	public void test2 () {
		b.enQueue((Object) 5);
		assertFalse("Fallo con isEmpty", b.isEmpty());
		assertFalse("Fallo con isFull", b.isFull());
		assertEquals("Fallo con deQueue", b.deQueue(), (Object) 5);
	}

}
