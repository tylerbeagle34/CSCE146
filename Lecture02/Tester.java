
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Person aPerson = new Person();
		Person person2 = new Student();
		Person person3 = new Ugrad();*/
		Person[] people = new Person[3];
		people[0] = new Person();
		people[1] = new Student();
		people[2] = new Ugrad();
		/*for(int i = 0; i < people.length; i++)
		{
			System.out.println(people[i]);
		}*/
		for(Person p : people) //for each loop
		{
			System.out.println(p);
		}
	}

}
