package test.data_structures;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Comparendo;
import model.data_structures.Queue;
import model.logic.Modelo;

public class TestQueue {

	private Queue<Comparendo> queue;

	private Modelo modelo;

	private final static int NUM_ELEMENTOS = 20;

	@Before
	public void setUp1() {
		modelo = new Modelo();
	}

	public void setUp2() {
		modelo.loadJSON(Modelo.SMALL);
		queue = modelo.cola;
	}

	@Test
	public void testEnqueue() {
		setUp1();
		setUp2();
		assertTrue("El primer elemento de la lista deberia ser: ID-29042", 29042==queue.first.getItem().OBJECTID);
	}

	@Test
	public void testDequeue() {
		setUp1();
		setUp2();
		int i = 0;
		while( i < NUM_ELEMENTOS) {
			queue.dequeue();
			i++;
		}
		assertTrue("El tamaño de la lista deberia ser " + 0, queue.size()==0);
	}

	@Test
	public void testSize() {
		setUp2();
		assertTrue("El tamaño de la lista deberia ser " + NUM_ELEMENTOS, queue.size()==NUM_ELEMENTOS);
	}

	@Test
	public void testIsEmpty() {
		setUp1();
		setUp2();
		assertTrue("La lista no deberia estar vacia", !queue.isEmpty());
	}

	@Test
	public void testHead() {
		setUp2();
		assertTrue("El primer elemento de la lista deberia ser: ID-29042", 29042==queue.first.getItem().OBJECTID);
	}
}
