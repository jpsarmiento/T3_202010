package view;
public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View() {}

	    /**
	     * Menu de la consola
	     */
		public void printMenu() {
			System.out.println("1. Leer archivo");
			System.out.println("2. shellSort");
			System.out.println("3. MergeSort");
			System.out.println("4. QuickSort");
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
		

}
