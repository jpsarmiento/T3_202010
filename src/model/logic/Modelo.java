package model.logic;

import model.data_structures.Comparendo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		Node it = cola.first;
		for(int i = 0; it!=null; i++) {
			arreglo[i] = (Comparable) it.getItem();
			it = it.getNext();
		}
		System.out.println("El arreglo tiene " + arreglo.length + "comparendos");
		return arreglo;
	}

}
