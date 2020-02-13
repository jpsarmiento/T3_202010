package model.data_structures;

public class Node<Item> {
	
	/**
	 * Contenido del nodo
	 */
	Item it;
	
	/**
	 * Referencia al siguiente nodo
	 */
	Node<Item> next;
	
	
	 /**
     * Constructor.
     */
	public Node(Item x) {
		it = x;
		next = null;
	}
	
	/**
     * Asignacion del contenido del nodo.
     */
	public void setItem(Item x) {
		it = x;
	}
	
	/**
     * Referencia al siguiente nodo.
     */
	public void setNext(Node<Item> x) {
		next = x;
	}
	
	/**
     * Cambiar el item
     */
	public Item getItem() {
		return it;
	}
	
	/**
     * Cambiar el nodo siguiente
     */
	public Node<Item> getNext() {
		return next;
	}
}
