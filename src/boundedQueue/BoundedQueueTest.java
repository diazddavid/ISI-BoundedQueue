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

}
