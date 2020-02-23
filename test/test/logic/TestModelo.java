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
	public void setUp1() {
		modelo = new Modelo();
	}

	public void setUp2() {
		modelo.loadJSON(Modelo.SMALL);
	}

	//ALEATORIOS
	public Comparable[] setUp3() {
		Comparable[] arreglo = new Comparable[NUM_ELEMENTOS];
		for(int i = 0; i < NUM_ELEMENTOS; i++) {
			arreglo[i] = Math.random();
		}
		return arreglo;
	}
	
	//ASCENDENTE
	public Comparable[] setUp4() {
		Comparable arreglo[] = new Comparable[NUM_ELEMENTOS];
		for(int i = 0; i < NUM_ELEMENTOS; i++) {
			arreglo[i] = i;
		}
		return arreglo;
	}

	//DESCENDENTE
	public Comparable[] setUp5() {
		Comparable arreglo[] = new Comparable[NUM_ELEMENTOS];
		for(int i = 0; i < NUM_ELEMENTOS; i++) {
			arreglo[i] = NUM_ELEMENTOS-i;
		}
		return arreglo;
	}


	@Test
	public void testDarTamano() {
		setUp1();
		setUp2();
		assertTrue("El tamaño debe ser de: "+ NUM_ELEMENTOS, NUM_ELEMENTOS == modelo.darTamanoCola());
	}

	@Test
	public void testPrimero() {
		setUp1();
		setUp2();
		assertTrue("La cabeza de la cola debe ser: ID-29042", 29042==modelo.primeroQueue().getItem().OBJECTID);
	}

	@Test
	public void testEliminar() {
		setUp1();
		setUp2();
		assertTrue("El objeto eliminado debe ser: ID-29042", 29042==modelo.eliminarQueue().OBJECTID);
	}

	@Test
	public void testShellSort() {
		Comparable arreglo[] = setUp3();
		modelo.shellSort(arreglo);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo));
		Comparable arreglo2[] = setUp4();
		modelo.shellSort(arreglo2);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo2));
		Comparable arreglo3[] = setUp5();
		modelo.shellSort(arreglo3);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo3));
	}

	@Test
	public void testMergeSort() {
		Comparable arreglo[] = setUp3();
		modelo.mergeSort(arreglo);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo));
		Comparable arreglo2[] = setUp4();
		modelo.mergeSort(arreglo2);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo2));
		Comparable arreglo3[] = setUp5();
		modelo.mergeSort(arreglo3);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo3));
	}

	@Test
	public void testQuickSort() {
		Comparable arreglo[] = setUp3();
		modelo.quickSort(arreglo);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo));
		Comparable arreglo2[] = setUp4();
		modelo.quickSort(arreglo2);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo2));
		Comparable arreglo3[] = setUp5();
		modelo.quickSort(arreglo3);
		assertTrue("El arreglo no esta ordenado", modelo.isSorted(arreglo3));
	}
}
