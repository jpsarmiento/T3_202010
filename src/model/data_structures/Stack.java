package model.data_structures;

public class Stack <T> implements IStack<T> {
	
	public Node<T> topStack;

	private int length;

	/**
	 * Constructor
	 */
	public Stack () {
		topStack = null;
		length = 0;
	}

	/**
	 * Agrega un elemento al final de la lista.
	 * @param Item x. Item a ser agregado en la lista generica
	 */
	public void push(T x) {
		if(topStack == null) {
			topStack = new Node<T>(x);
			length = 1;
		}
		else {
			Node<T> newLast = new Node<T>(x);
			newLast.setNext(topStack);
			topStack = newLast;
			length++;
		}
	}


	/**
	 * Se elimina un elemento de la lista con la posicion dada.
	 * @param int pos. Posicion del elemento a eliminar.
	 * @return Item. Item eliminado
	 * @throws Exception. Si la lista esta vacia o la posicion es mayor a la cantidad de elementos.
	 */
	public T pop() {
		if(isEmpty()) 
			return  null;
		else {
			T elemento = topStack.getItem();
			Node<T> nuevo = topStack.getNext();
			topStack.setNext(null);
			topStack = nuevo;
			length --;
			return elemento;
		}
	}


	/**
	 * Numero de elementos de la lista encadenada
	 * @return int. numero de elementos de la lista.
	 */
	public int size() {
		return length;
	}
		
	/**
	 * Indica si la pila esta vacia.
	 * @return true si la cola tiene 0 elementos. false en caso contrario.
	 */
	public boolean isEmpty() {
		return (topStack==null);
	}
	
	/**
	 * Da el primer elemento de la pila.
	 * @return T. Primer elemento de la pila.
	 */
	public Node<T> head() {
		return topStack;
	}

}