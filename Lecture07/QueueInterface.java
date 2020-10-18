
public interface QueueInterface <T>{
	public void enqueue(T data);
	public T dequeue();
	public T peek();
	public void print();
}
