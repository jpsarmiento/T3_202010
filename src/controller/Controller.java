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
					if(!modelo.inicializado) {
						modelo.loadJSON(Modelo.SMALL);
						view.printMessage("La cola tiene " + modelo.darTamanoCola() + " comparendos.");
						view.printMessage(modelo.primeroQueue().getItem().toString());
						view.printMessage(modelo.ultimoQueue().getItem().toString());
					}
					else
						view.printMessage("Los datos ya han sido cargados previamente!");
					view.printMessage("");
					view.printMenu();
				}
				//SHELL SORT SHELL SORT SHELL SORT SHELL SORT SHELL SORT SHELL SORT SHELL SORT SHELL SORT SHELL SORT
				else if(option==2) {
					if(modelo.inicializado) {
						Comparable datos[] = modelo.copiarComparendos(); 	//Copia de los comparendos en un arreglo
						long startTime = System.currentTimeMillis(); 		//Tiempo actual
						//Ejecucion del alg de ordenamiento
						modelo.shellSort(datos);
						long endTime = System.currentTimeMillis(); 			//Tiempo ya finalizada la carga
						view.printMessage("Tiempo de ordenamiento: " + (endTime-startTime) + " milisegundos.");
						view.printMessage("");
						if(datos.length>=20) {
							view.printMessage("Los primeros 10 datos son: ");
							for(int i = 0; i < 10; i++) 
								view.printMessage(datos[i].toString());
							view.printMessage("Los ultimos 10 datos son: ");
							for(int i = datos.length-10; i < datos.length; i++)
								view.printMessage(datos[i].toString());
							view.printMessage("");
							view.printMenu();
						}
						else {
							view.printMessage("No hay suficientes datos para mostrar los 10 primeros y 10 ultimos");
							view.printMessage("El arreglo ordenado: ");
							for(int i = 0; i < datos.length; i++)
								view.printMessage(datos[i].toString());
						}
					}
					else {
						view.printMessage("Es necesario realizar primero la lectura de datos.");
						view.printMenu();
					}
				}
				// MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT
				else if(option==3) {
					if(modelo.inicializado) {
						Comparable datos[] = modelo.copiarComparendos(); 	//Copia de los comparendos en un arreglo
						long startTime = System.currentTimeMillis(); 		//Tiempo actual
						//Ejecucion del alg de ordenamiento
						modelo.mergeSort(datos);
						long endTime = System.currentTimeMillis(); 			//Tiempo ya finalizada la carga
						view.printMessage("Tiempo de ordenamiento: " + (endTime-startTime) + " milisegundos.");
						view.printMessage("");
						if(datos.length>=20) {
							view.printMessage("Los primeros 10 datos son: ");
							for(int i = 0; i < 10; i++) 
								view.printMessage(datos[i].toString());
							view.printMessage("Los ultimos 10 datos son: ");
							for(int i = datos.length-10; i < datos.length; i++)
								view.printMessage(datos[i].toString());
							view.printMessage("");
							view.printMenu();
						}
						else {
							view.printMessage("No hay suficientes datos para mostrar los 10 primeros y 10 ultimos");
							view.printMessage("El arreglo ordenado: ");
							for(int i = 0; i < datos.length; i++)
								view.printMessage(datos[i].toString());
						}
					}

					else {
						view.printMessage("Es necesario realizar primero la lectura de datos.");
						view.printMenu();
					}
				}
				// QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT
				else if(option==4) {
					if(modelo.inicializado) {
						Comparable datos[] = modelo.copiarComparendos(); 	//Copia de los comparendos en un arreglo
						long startTime = System.currentTimeMillis(); 		//Tiempo actual
						//Ejecucion del alg de ordenamiento
						modelo.quickSort(datos);
						long endTime = System.currentTimeMillis(); 			//Tiempo ya finalizada la carga
						view.printMessage("Tiempo de ordenamiento: " + (endTime-startTime) + " milisegundos.");
						view.printMessage("");
						if(datos.length>=20) {
							view.printMessage("Los primeros 10 datos son: ");
							for(int i = 0; i < 10; i++) 
								view.printMessage(datos[i].toString());
							view.printMessage("Los ultimos 10 datos son: ");
							for(int i = datos.length-10; i < datos.length; i++)
								view.printMessage(datos[i].toString());
							view.printMessage("");
							view.printMenu();
						}
						else {
							view.printMessage("No hay suficientes datos para mostrar los 10 primeros y 10 ultimos");
							view.printMessage("El arreglo ordenado: ");
							for(int i = 0; i < datos.length; i++)
								view.printMessage(datos[i].toString());
						}
					}

					else {
						view.printMessage("Es necesario realizar primero la lectura de datos.");
						view.printMenu();
					}
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
