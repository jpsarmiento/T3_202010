package model.data_structures;
import java.util.ArrayList;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

public class Comparendo 
{
	
	/**
	 * ID del comparendo.
	 */
	private int OBJECTID;
	
	/**
	 * Fecha del comparendo.
	 */
	private String FECHA_HORA;
	
	/**
	 * Medio de deteccion de la infraccion.
	 */
	private String MEDIO_DETE;
	
	/**
	 * Tipo de vehiculo de la infraccion.
	 */
	private String CLASE_VEHI;
	
	/**
	 * Tipo de servicio del vehiculo.
	 */
	private String TIPO_SERVI;
	
	/**
	 * Titulo de la infraccion.
	 */
	private String INFRACCION;
	
	/**
	 * Descripcion de la infraccion cometida.
	 */
	private String DES_INFRAC;
	
	/**
	 * Localidad donde ocurrio la infraccion.
	 */
	private String LOCALIDAD;
	
	/**
	 * Par de cordenadas (lat y lon).
	 */
	private ArrayList<Double> coordinates;
	
	/**
	 * Constructor.
	 * @param int id. ID de la infraccion
	 * @param String fecha. Fecha del comparendo
	 * @param String medio. Medio de deteccion.
	 * @param String vehiculo. Tipo de vehiculo
	 * @param String tipoServ. Tipo de servicio del vehiculo
	 * @param String infraccion. Titulo de la infraccion.
	 * @param String descripcion. Descripcion de la infraccion
	 * @param String localidad. Localidad de los hechos.
	 * @param ArrayList<Double> cordenadas. Par de cordenadas.
	 */
	public Comparendo (int id, String fecha, String medio, String vehiculo, String tipoServ, String infraccion, String descripcion, String localidad, ArrayList<Double> cordenadas)
	{
		OBJECTID = id;
		FECHA_HORA = fecha;
		MEDIO_DETE = medio;
		CLASE_VEHI = vehiculo;
		TIPO_SERVI = tipoServ;
		INFRACCION = infraccion;
		DES_INFRAC = descripcion;
		LOCALIDAD = localidad;
		coordinates = cordenadas;
	}
	
	@Override
	public String toString()
	{
		return ("Infracción #" + OBJECTID + ": " + DES_INFRAC + " en: " + LOCALIDAD + " coords: " + coordinates.get(0) + ", " + coordinates.get(1));
	}
	
	/**
	 * @return OBJECTID
	 */
	public int getID()
	{
		return OBJECTID;
	}

}
