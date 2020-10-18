
public class ArrayStack <T> implements StackInterface <T> {
	private T[] stack;
	private int head; //Points to the first null element after the head
	public static final int DEFAULT_SIZE = 100;
	public ArrayStack()
	{
		init(DEFAULT_SIZE);
	}
	public ArrayStack(int size)
	{
		init(size);
	}
	public void init(int size)
	{
		head = 0;
		if(size <= 0)
		{
			return;
		}
		stack = (T[]) (new Object[size]);
	}
	public void push(T aData)
	{
		if(head >= stack.length) //Stack is full
		{
			return;
		}
		stack[head] = aData;
		head ++;
	}
	public T pop()
	{
		if(head <= 0) //Stack is empty
		{
			return null;
		}
		T ret = stack[head - 1];
		head --;
		return ret;
	}
	public T peek()
	{
		if(head > 0)
		{
			return stack[head - 1];
		}
		else
		{
			return null;
		}
	}
	public void print()
	{
		for(int i = head - 1; i >= 0; i --)
		{
			System.out.println(stack[i]);
		}
	}
}
