
public class GLLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenLinkedList<String> strList = new GenLinkedList<String>();
		//GenLinkedList<int> intList = new GenLinkedList<int>(); //ERROR
		GenLinkedList<Integer> intList = new GenLinkedList<Integer>(); //Correct
		String thing = "*";
		for(int i = 0; i < 5; i++)
		{
			strList.insert(thing);
			thing += "*";
			intList.insert(i);
		}
		strList.print();
		intList.print();
		for(int i = 0; i < 5; i++)
		{
			intList.moveCurrentForward();
		}
		intList.setCurrent(intList.getCurrent() + 10);
		intList.print();
	}

}
