package controller;

import java.util.Scanner;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	/**
	 * Interaccion del usuario con el programa.
	 */
	public void run()
	{
		@SuppressWarnings("resource")
		Scanner lector = new Scanner(System.in);
		view.printMenu();

		try {
			int option = lector.nextInt();
			while(option != 5)
			{
				if(option==1) {
					modelo.loadJSON(Modelo.SMALL);
					view.printMessage("La cola tiene " + modelo.darTamanoCola() + " comparendos.");
					view.printMessage("La pila tiene " + modelo.darTamanoPila() + " comparendos.");
					view.printMessage("");
					view.printMenu();
				}
				else if(option==2) {
					view.printCluster(modelo);
					view.printMenu();
				}
				else if(option==3) {
					view.printMessage("Ingrese el número de comparendos a buscar: ");
					int n = lector.nextInt();
					view.printMessage("");
					view.printMessage("Ingrese el tipo  de infracción a buscar: ");
					String mensaje = lector.next();
					view.printMessage("");
					view.printComparendos(modelo, n, mensaje);
					view.printMenu();
				}
				else if(option==4) {
					view.printMessage("La cola tiene " + modelo.darTamanoCola() + " comparendos.");
					view.printMessage("La pila tiene " + modelo.darTamanoPila() + " comparendos.");
				}
				else {
					view.printMessage("Numero invalido");
					view.printMessage("");
					view.printMenu();
				}
				option = lector.nextInt();
			}
			if(option==5)
				System.out.println("Ha salido con exito.");
		
		}
		catch(Exception e) {
			view.printMessage("Caracter no válido");
			view.printMessage("");
			run();
		}
	}	
}
