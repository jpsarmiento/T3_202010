package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;
import org.junit.Before;
import org.junit.Test;

public class TestModelo 
{

	private Modelo modelo;
	
	private final static int NUM_ELEMENTOS = 20;
	@Before
	public void setUp1()
	{
		modelo = new Modelo();
	}

	public void setUp2()
	{
		modelo.loadJSON(Modelo.SMALL);
	}

	@Test
	public void testDarTamano()
	{
		setUp1();
		setUp2();
		assertTrue("El tamaño debe ser de: "+ NUM_ELEMENTOS, NUM_ELEMENTOS == modelo.darTamanoCola());
		assertTrue("El tamaño debe ser de: "+ NUM_ELEMENTOS, NUM_ELEMENTOS == modelo.darTamanoPila());
	}

	@Test
	public void testPrimero() {
		setUp1();
		setUp2();
		assertTrue("La cabeza de la cola debe ser: ID-29042", 29042==modelo.primeroQueue().getItem().OBJECTID);
		assertTrue("La cabeza de la cola debe ser: ID-209146", 209146==modelo.primeroStack().getItem().OBJECTID );
	}
	
	@Test
	public void testEliminar() {
		setUp1();
		setUp2();
		assertTrue("El objeto eliminado debe ser: ID-29042", 29042==modelo.eliminarQueue().OBJECTID);
		assertTrue("El objeto eliminado debe ser: ID-209146", 209146==modelo.eliminarStack().OBJECTID );
	}
}
