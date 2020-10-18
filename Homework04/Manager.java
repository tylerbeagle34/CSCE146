/*
 * Written by Warren Beagle
 * Homework04: Reverse Polish Calculator!
 */
import java.io.File;
import java.util.Scanner;
public class Manager {
	private LinkedListStack<Integer> list; //Instance of the LinkedListStack
	public static final String DELIM = " "; //Delimeter
	//Reads the file
	public void readFile(String fileName)
	{
		if(fileName == null)
		{
			return;
		}
		//Assume we create a new list
		list = new LinkedListStack<Integer>();
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				list = new LinkedListStack<Integer>();
				String fileLine = fileScanner.nextLine();
				System.out.println("Calculating Result for: " + fileLine);
				String[] splitLines = fileLine.split(DELIM); //Splits the line using the delimeter
				boolean divideByZero = false;
				boolean letter = false;
				for(int i = 0; i < splitLines.length; i ++)
				{
					String token = splitLines[i]; //Gets the token at a specific place 
					switch(token)
					{
					case "+": //Adds
						if(list.peek() == null) //No elements to add
						{
							break;
						}
						else
						{
							list.push(list.pop() + list.pop());
						}
						break;
					case "-": //Subtracts
						if(list.peek() == null) //No elements to subtract
						{
							break;
						}
						else
						{
							list.push(-list.pop() + list.pop());
						}
						break;
					case "*": //Multiplies
						if(list.peek() == null) //No elements to multiply
						{
							break;
						}
						else
						{
							list.push(list.pop() * list.pop());
						}
						break;
					case "/": //Divides
						int denom = list.pop();
						if(denom == 0) //Division by 0
						{
							System.out.println("Cannot divide by 0");
							list.push(0); //Pushes 0 so the result is zero
							divideByZero = true; //Sets divide by zero to true
						}
						else
						{
							if(list.peek() == null) //No elements to divide
							{
								break;
							}
							else
							{
								list.push(list.pop() / denom);
							}	
						}
						break;
					default: //Adds values to the stack
						try
						{
							list.push(Integer.parseInt(token));
						}
						catch(Exception e) //Catches values that are not integers
						{
							System.out.println("Exception! For input string: " + token);
							for(int j = 0; j <= splitLines.length; j ++)
							{
								list.push(0); //Pushes 0 so the result is 0
							}
							letter = true; //Sets letter to true
						}
						break;
					}
				}
				if(list.count() != 1)
				{
					//If statements for different error cases
					if(divideByZero == true)
					{
						System.out.println("Result is " + list.peek());
					}
					else if(letter == true)
					{
						System.out.println("Result is " + list.peek());
					}
					else
					{
						System.out.println("Ill formatted expression");
						list.push(0);
						System.out.println("Result is " + list.peek());
					}
				}
				else if(list.count() == 1)
				{
					System.out.println("Result is " + list.peek());
				}
			}
			fileScanner.close(); //Closes the file
		}
		catch(Exception e) //Exception
		{
			System.out.println(e);
		}
	}
}
