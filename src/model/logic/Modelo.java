package model.logic;

import model.data_structures.Comparendo;
import model.data_structures.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import com.google.gson.*;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private LinkedList datos;

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
		datos = new LinkedList();
		gson = new Gson();
	}


	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.getLength();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Comparendo x)
	{	
		datos.append(x);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 * @throws Exception 
	 */

	public Comparendo buscarPosicion(int x)
	{
		try
		{
			return (Comparendo) datos.getAt(x);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar_
	 * @return dato eliminado
	 * @throws Exception 
	 */
	public Comparendo eliminar(int x)
	{
		try
		{
			return (Comparendo) datos.delete(x);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	/**
	 * Ejemplo de usar gson con un objeto
	 * @throws Exception 
	 */
	public void example()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("./data/abc.geojson")));
			Comparendo ejemplo = gson.fromJson(br, Comparendo.class);
			agregar(ejemplo);
		}
		catch(Exception e)
		{
			System.out.println("Error de archivo");
		}
	}

	/**
	 * Lectura del geojson
	 */
	public ArrayList<String> readJSON()
	{
		ArrayList<String> objects = new ArrayList<String>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(SOURCE)));
			String line = br.readLine();
			while(line != null)
			{
				String object = "";
				for(int i = 0; i < 15; i++)
				{
					object += line;
					line = br.readLine();
				}
				objects.add(object);

			}
		}
		catch(Exception e)
		{

		}
		return objects;
	}

	/**
	 * Carga del geojson a objetos de la lista.
	 */
	public void loadJSON()
	{
		ArrayList<String> objects = readJSON();
		for(int i = 0; i < objects.size(); i++)
		{
			Comparendo obj = gson.fromJson(objects.get(i), Comparendo.class);
			agregar(obj);
		}

	}

	/**
	 * Imprimir los elemntos de la lista por medio de sus metodos toString().
	 */
	public String imprimirLista()
	{
		String lista = "";
		for(int i = 0; i < datos.getLength(); i++)
		{
			try
			{
				lista += datos.getAt(0).toString();
			}
			catch(Exception e)
			{

			}
		}
		return lista;
	}


}
