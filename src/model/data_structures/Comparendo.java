package model.data_structures;
import java.util.Date;

public class Comparendo implements Comparable<Comparendo>{
	
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
	
		
	@Override
	public String toString() {
		return "Comparendo [ID:" + OBJECTID + ", FECHA:" + FECHA_HORA + ", TIPO DE VEHICULO:" + CLASE_VEHI + ", TIPO DE SERVICIO:" + TIPO_SERVI
				+ ", INFRACCION:" + INFRACCION + ", LOCALIDAD:" + LOCALIDAD + "]";
	}


	@Override
	public int compareTo(Comparendo o) {
		if(this.FECHA_HORA.compareTo(o.FECHA_HORA)!=0)
			return this.FECHA_HORA.compareTo(o.FECHA_HORA);
		else
			return this.OBJECTID-o.OBJECTID;
	}
}
