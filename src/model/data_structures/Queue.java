package model.data_structures;

public class Queue<T> {
	//FIFO

	private Node<T> first;

	private Node<T> last;

	private int length;

	/**
	 * Constructor
	 */
	public Queue() {
		first = null;
		last = null;
		length = 0;
	}

	/**
	 * Agrega un elemento al final de la lista.
	 * @param T element. Elemento a ser agregado en la cola.
	 */
	public void enqueue(T element) {
		if(isEmpty()) {
			first = new Node<T>(element);
			last = first;;
			length = 1;
		}
		else {
			Node<T> newLast = new Node<T>(element);
			last.setNext(newLast);
			last = newLast;
			length++;
		}
	}

	/**
	 * Elimina el primer elemento de la cola.
	 * @return T. Elemento que esta de primero.
	 */
	public T dequeue() {
		if(isEmpty())
			return null;
		else {
			T element = first.getItem();
			Node<T> newFirst = first.getNext();
			first.setNext(null);
			first = newFirst;
			length--;
			return element;
		}
	}
	

	/**
	 * Da el tamano de la cola.
	 * @return int. Numero de elementos en la cola.
	 */
	public int size() {
		return length;
	}

	public boolean isEmpty()
	{
		if(length==0)
			return true;
		else
			return false;

	}
	
	/**
	 * Da el primer elemento de la cola.
	 * @return T. Primer elemento de la cola.
	 */
	public Node<T> head() {
		return first;
	}
}
