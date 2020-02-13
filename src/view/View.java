package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }

	    /**
	     * Menu de la consola
	     */
		public void printMenu()
		{
			System.out.println("1. Leer archivo");
			System.out.println("2. Realizar cluster");
			System.out.println("3. Comparendos por tipo  de Infraccion");
			System.out.println("4. Numero de elementos");
			System.out.println("5. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

	    /**
	     * Imprimir mensaje
	     * @param String mensaje. Mensaje a imprimir
	     */

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printCluster(Modelo modelo) {
			modelo.imprimirCluster();
			System.out.println("");
		}
			
		public void printComparendos(Modelo modelo, int n , String pInfraccion) {
			modelo.imprimirInfraccion(n, pInfraccion);
			System.out.println("");
		}
}
