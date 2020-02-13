package model.data_structures;

public interface IQueue<T> {
		
	public T dequeue();
	
	public Node<T> head();

	public int size();
	
	public boolean isEmpty();
	
	public void enqueue(T element);
}
