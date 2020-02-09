package test.data_structures;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Queue;

public class TestQueue {

	private Queue queue;
	
	private final static int NUM_ELEMENTOS = 10;
	
	@Before
	public void setUp1() {
		queue = new Queue();
	}
	
	public void setUp2() {
		
	}
	
	@Test
	public void testEnqueue() {
		setUp1();
	}
	
	@Test
	public void testDequeue() {
		setUp1();
		setUp2();
	}
	
	@Test
	public void testSize() {
		setUp1();
		assertTrue("El tamano de la lista deberia ser 0", queue.size()==0);
		setUp2();
		assertTrue("El tamaño de la lista deberia ser " + NUM_ELEMENTOS, queue.size()==NUM_ELEMENTOS);
	}
	
	@Test
	public void testIsEmpty() {
		setUp1();
		assertTrue("La lista deberia estar vacia", queue.isEmpty());
		setUp2();
		assertTrue("La lista no deberia estar vacia", !queue.isEmpty());
	}
	
	@Test
	public void testHead() {
		setUp1();
		assertTrue("El primer elemento deberia ser null", queue.head()==null);
		setUp2();
	}
}
