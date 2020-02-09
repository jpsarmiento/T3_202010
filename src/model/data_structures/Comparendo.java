package model.data_structures;
import java.util.Date;

public class Comparendo {
	
	/**
	 * ID del comparendo.
	 */
	public int OBJECTID;
	
	/**
	 * Fecha del comparendo.
	 */
	public Date FECHA_HORA;
	
	/**
	 * Medio de deteccion de la infraccion.
	 */
	public String MEDIO_DETE;
	
	/**
	 * Tipo de vehiculo de la infraccion.
	 */
	public String CLASE_VEHI;
	
	/**
	 * Tipo de servicio del vehiculo.
	 */
	public String TIPO_SERVI;
	
	/**
	 * Titulo de la infraccion.
	 */
	public String INFRACCION;
	
	/**
	 * Descripcion de la infraccion cometida.
	 */
	public String DES_INFRAC;
	
	/**
	 * Localidad donde ocurrio la infraccion.
	 */
	public String LOCALIDAD;
	
	/**
	 * Par de cordenadas (lat y lon).
	 */
	public double latitud;
	
	public double longitud;
	
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
		
	@Override
	public String toString() {
		return "Comparendo [ID:" + OBJECTID + ", FECHA:" + FECHA_HORA + ", TIPO DE VEHICULO:" + CLASE_VEHI + ", TIPO DE SERVICIO:" + TIPO_SERVI
				+ ", INFRACCION:" + INFRACCION + ", LOCALIDAD:" + LOCALIDAD + "]";
	}
	
	/**
	 * @return OBJECTID
	 */
	public int getID() {
		return OBJECTID;
	}

}
