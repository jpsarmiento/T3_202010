package model.data_structures;

public interface IQueue<T extends Comparable<T>> {
		
	public T dequeue();
	
	public Node<T> head();

	public int size();
	
	public boolean isEmpty();
	
	public void enqueue(T element);
}
