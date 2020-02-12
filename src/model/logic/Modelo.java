package model.logic;

import model.data_structures.Comparendo;
import model.data_structures.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
	private Queue cola;

	/**
	 * Gson utilizado para deserializar el archivo
	 */
	private Gson gson;

	/**
	 * Direccion del archivo de datos.
	 */
	public final static String SOURCE = "./data/comparendos_dei_2018_small.geojson";
	/**
	 * Constructor del modelo del mundo
	 */
	public Modelo()
	{
		cola = new Queue();
		gson = new Gson();
	}


	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return cola.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Comparendo x)
	{	
		cola.enqueue(x);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 * @throws Exception 
	 */

	public Node primero() {
		return cola.head();
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar_
	 * @return dato eliminado
	 * @throws Exception 
	 */
	public Comparendo eliminar() {
			return (Comparendo) cola.dequeue();	
	}

	/**
	 * Carga del geojson a objetos de la lista.
	 */
	public void loadJSON() {
		ArrayList<Comparendo> objects = new ArrayList<>();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(SOURCE));
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
		} 
		catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Imprimir los elemntos de la lista por medio de sus metodos toString().
	 */
	public void imprimirLista() {
		Node actual = primero();
		for(int i = 0; i < darTamano(); i++) {
				System.out.println(actual.getItem().toString());
				actual = actual.getNext();
		}
	}
	
	public Queue<Comparendo> cluster()
	{
		Queue<Comparendo> rta = new Queue<Comparendo>();
		Queue<Comparendo> rta2 = new Queue<Comparendo>();
		Node<Comparendo> head = cola.head();
		String infraccion = "";
		while(head!=null) {
			if(!head.getItem().INFRACCION.equals(infraccion)) {
				infraccion = head.getItem().INFRACCION;
				rta2.restart();
				rta2.enqueue(head.getItem());
			}
			else {
				rta2.enqueue(head.getItem());
			}
			if(rta2.size()>rta.size()) {
				rta = rta2;
			}
			head = head.getNext();
		}
		return rta;
	}
	
	public void imprimirCluster() {
		Queue<Comparendo> cluster = cluster();
		Node<Comparendo> actual = cluster.head();
		for(int i = 0; i < cluster.size() && actual != null; i++) {
				System.out.println(actual.getItem().toString());
				actual = actual.getNext();
		}
	}
	
	public void imprimirComparendos() {
		
	}


}
