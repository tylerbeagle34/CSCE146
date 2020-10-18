
public class LLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntLinkedList list = new IntLinkedList();
		for(int i = 0; i < 10; i++)
		{
			list.insert(i);
		}
		list.print();
		//Move current 4 elements
		for(int i = 0; i < 4; i++)
		{
			list.moveCurrentForward();
		}
		System.out.println("\n" + list.getCurrent());
		list.setCurrent(list.getCurrent() + 10);
		System.out.println(list.getCurrent());
		list.insertAfterCurrent(79);
		list.print();
		System.out.println("Moving forward twice and deleting the current");
		list.moveCurrentForward();
		list.moveCurrentForward();
		list.deleteCurrent();
		list.print();
	}

}
