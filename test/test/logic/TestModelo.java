package test.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.data_structures.Comparendo;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo 
{

	private Modelo modelo;	
	@Before
	public void setUp1()
	{
		modelo = new Modelo();
	}

	public void setUp2()
	{
		ArrayList<Double> array = new ArrayList<Double>();
		array.add(10.0067);
		array.add(-20.0034);
		Comparendo a = new Comparendo(1, "", "", "", "", "", "", "", array);
		Comparendo b = new Comparendo(2, "", "", "", "", "", "", "", array);
		Comparendo c = new Comparendo(3, "", "", "", "", "", "", "", array);
		Comparendo d = new Comparendo(4, "", "", "", "", "", "", "", array);
		modelo.agregar(a);
		modelo.agregar(b);
		modelo.agregar(c);
		modelo.agregar(d);
	}

	@Test
	public void testDarTamano()
	{
		// TODO
		setUp1();
		setUp2();
		assertEquals(4, modelo.darTamano());
	}

	@Test
	public void testBuscarPosicion() 
	{
		// TODO Completar la prueba
		setUp1();
		setUp2();
		try
		{
			assertEquals("Infracción #4:  en:  coords: 10.0067, -20.0034", modelo.buscarPosicion(3).toString());
			assertEquals("Infracción #1:  en:  coords: 10.0067, -20.0034", modelo.buscarPosicion(0).toString());
		}
		catch(Exception e)
		{

		}
	}

	@Test
	public void testEliminar() 
	{
		// TODO Completar la prueba
		setUp1();
		setUp2();
		try
		{
			assertEquals("Infracción #2:  en:  coords: 10.0067, -20.0034", modelo.eliminar(1).toString());
			assertEquals(3, modelo.darTamano());
		}
		catch(Exception e)
		{

		}

	}

}
