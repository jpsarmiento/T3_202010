package controller;

import java.util.Scanner;

import model.data_structures.Comparendo;
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
		Scanner lector = new Scanner(System.in);
		String rta = "";
		view.printMenu();

		int option = lector.nextInt();

		while(option != 6)
		{
			if(option==1) {
				modelo.loadJSON();
				view.printMessage("La cola tiene " + modelo.darTamanoCola() + " comparendos.");
				view.printMessage("La pila tiene " + modelo.darTamanoPila() + " comparendos.");

				view.printMessage("");
				view.printMenu();
			}
			else if(option==4) {
				view.printModelo(modelo);
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
			else if(option==5) {
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
		if(option==6)
			System.out.println("Ha salido con exito.");
	}	
}
