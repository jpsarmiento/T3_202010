package model.logic;

import model.data_structures.Comparendo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import model.data_structures.Node;
import model.data_structures.Queue;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */

	private static Random random;

	private static Comparable[] aux; 

	public Queue<Comparendo> cola;

	public boolean inicializado;

	/**
	 * Direccion del archivo de datos.
	 */
	public final static String SMALL = "./data/comparendos_dei_2018_small.geojson";

	public final static String BIG = "./data/comparendos_dei_2018.geojson";

	/**
	 * Constructor del modelo del mundo
	 */
	public Modelo() {
		cola = new Queue<Comparendo>();
		inicializado = false;
		random = new Random();
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoCola() {
		return cola.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Comparendo x) {	
		cola.enqueue(x);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 * @throws Exception 
	 */

	public Node<Comparendo> primeroQueue() {
		return cola.head();
	}

	public Node<Comparendo> ultimoQueue() {
		return cola.back();
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar_
	 * @return dato eliminado
	 * @throws Exception 
	 */
	public Comparendo eliminarQueue() {
		return (Comparendo) cola.dequeue();	
	}

	/**
	 * Carga del geojson a objetos de la lista.
	 */
	public void loadJSON(String pArchivo) {
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(pArchivo));
			JsonElement element = JsonParser.parseReader(reader);
			JsonArray featuresArray = element.getAsJsonObject().get("features").getAsJsonArray();

			SimpleDateFormat dateParser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: featuresArray) {
				Comparendo c = new Comparendo();
				c.OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				c.FECHA_HORA = dateParser.parse(s); 
				c.MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				c.CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				c.TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				c.INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				c.DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				c.LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				c.longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();
				c.latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				agregar(c);
			}
			inicializado = true;
		} 
		catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
	}

	public Comparable<Comparendo>[] copiarComparendos(){
		Comparable<Comparendo>[] arreglo = new Comparable[cola.size()];
		Node<Comparendo> it = cola.first;
		for(int i = 0; it!=null; i++) {
			arreglo[i] = it.getItem();
			it = it.getNext();
		}
		System.out.println("El arreglo tiene " + arreglo.length + " comparendos");
		return arreglo;
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b)<0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}

	public void shellSort(Comparable datos[]) {
		int N = datos.length;
		int h = 1;
		while(h < N/3) {
			h = (3*h) +1;
		}
		while(h>=1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j>=h && less(datos[j], datos[j-h]); j-=h) {
					exch(datos, j, j-h);
				}
			}
			h = h/3;
		}
	}

	public void mergeSort(Comparable datos[]) {
		aux = new Comparable[datos.length];
		sortM(datos, 0, datos.length - 1); // Allocate space just once.
	}

	private static void sortM(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return; // Sort a[lo..hi].
		int mid = lo + (hi - lo)/2;
		sortM(a, lo, mid);
		// Sort left half.
		sortM(a, mid+1, hi);
		// Sort right half.
		merge(a, lo, mid, hi);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi)
	{ // Merge a[lo..mid] with a[mid+1..hi].
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
			if (i > mid) a[k] = aux[j++];
			else if (j > hi ) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
	}

	public void quickSort(Comparable datos[]) {
		shuffle(datos); // Eliminate dependence on input.
		sortQ(datos, 0, datos.length - 1);
	}

	public static void shuffle(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + random.nextInt(n-i);     // between i and n-1
			Comparable temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	private static int partition(Comparable[] a, int lo, int hi)
	{ // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi+1; // left and right scan indices
		Comparable v = a[lo]; // partitioning item
		while (true)
		{ // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	private static void sortQ(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sortQ(a, lo, j-1); // Sort left part a[lo .. j-1].
		sortQ(a, j+1, hi); // Sort right part a[j+1 .. hi].
	}


}
