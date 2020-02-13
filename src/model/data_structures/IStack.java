package model.data_structures;

public interface IStack<T> {

	public void push(T x);
	
	public T pop();
	
	public int size();
	
	public boolean isEmpty();
	
	public Node<T> head();
}
