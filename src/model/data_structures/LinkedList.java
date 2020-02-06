package model.data_structures;

public class LinkedList <Item>
{

	private Node<Item> first;

	private Node<Item> last;

	private int length;

	/**
	 * Constructor
	 */
	public LinkedList ()
	{
		first = null;
		last = null;
		length = 0;
	}

	/**
	 * Agrega un elemento al final de la lista.
	 * @param Item x. Item a ser agregado en la lista generica
	 */
	public void append(Item x)
	{
		if(first == null) {
			first = new Node<Item>(x);
			last = first;;
			length = 1;
		}
		else
		{
			Node<Item> newLast = new Node<Item>(x);
			last.setNext(newLast);
			last = newLast;
			length++;
		}
	}


	/**
	 * Se elimina un elemento de la lista con la posicion dada.
	 * @param int pos. Posicion del elemento a eliminar.
	 * @return Item. Item eliminado
	 * @throws Exception. Si la lista esta vacia o la posicion es mayor a la cantidad de elementos.
	 */
	public Item delete(int pos) throws Exception
	{
		if(pos>length-1)
			throw new Exception("Out of bounds!");

		if(pos == 0)
		{
			Item deleted = first.getItem();
			Node<Item> a = first.getNext();
			first.setNext(null);
			first = a;
			length--;
			return deleted;
		}

		else
		{
			int i = 1;
			Node<Item> a = first.getNext();
			Node<Item> b = first;
			while(pos != i)
			{
				b = b.getNext();
				a = a.getNext();
				i++;
			}
			Item deleted = a.getItem();
			b.setNext(a.getNext());
			a.setNext(null);
			length--;
			return deleted;
		}
	}


	/**
	 * Numero de elementos de la lista encadenada
	 * @return int. numero de elementos de la lista.
	 */
	public int getLength()
	{
		return length;
	}


	/**
	 * Se retorna el elemento de la lista con la posicion dada.
	 * @param int pos. Posicion del elemento a buscar.
	 * @return Item. Item buscado por indice
	 * @throws Exception. Si la lista esta vacia o la posicion es mayor a la cantidad de elementos.
	 */
	public Item getAt(int pos) throws Exception
	{
		if(pos>length-1)
			throw new Exception("Out of bounds!");

		int i = 0;
		Node<Item> r = first;
		while(i!=pos)
		{
			r = r.getNext();
			i++;
		}
		return r.getItem();
	}	

}

