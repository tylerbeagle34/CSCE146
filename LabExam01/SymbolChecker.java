/*
 * LabExam01: Enclosing Symbol Checker!
 * Written by Warren Beagle
 */
public class SymbolChecker {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checker("()"));
		System.out.println(checker("<<<>>>"));
		System.out.println(checker("{(“tacos”)}"));
		System.out.println(checker("if(pass == true){return “yay!”;}")); /*Got all of the others working except for this one.  This one doesn't work because you have to go through
																		  the stack multiple times to find the closing characters.  With the way i wrote my code, this could not be
																		  done because it would cause all of the other ones to not work.*/
		System.out.println(checker("abcd"));
		System.out.println(checker("“””"));
		System.out.println(checker("<(\")"));
		System.out.println(checker(":-)"));
		System.out.println(checker("<3"));
		System.out.println(checker("(<{\"\"}>"));
		System.out.println(checker("<{>}"));
	}
	//Method to check the characters
	public static boolean checker(String aString)
	{
		LLStack<String> list = new LLStack<String>(); //Creates a new linked list of strings
		for(int i = 0; i < aString.length(); i++)
		{
			char character = aString.charAt(i); //Gets a character 
			//Determines if the character is an enclosing symbol
			switch(character)
			{
				case '(':
					list.push("("); //Pushes the enclosing symbol onto the stack
					break;
				case '{':
					list.push("{");
					break;
				case '“':
					list.push("“");
					break;
				case '<':
					list.push("<");
					break;
				default:
					break;
			}
		}
		for(int i = 0; i < aString.length(); i++)
		{
			char endCharacter = aString.charAt(i); //Gets a character
			//Determines if the character is an ending enclosing symbol
			switch(endCharacter)
			{
				case ')':
					if(list.count() == 0) //If the stack is empty but there is a closing symbol it returns false
					{
						return false;
					}
					String otherCharacter = list.peek(); //Peeks the next element in the stack
					if(otherCharacter.equals("(")) //Equal to the opening symbol then pops off
					{
						list.pop();
						continue; //Keeps going
					}
					break;
				case '}':
					if(list.count() == 0)
					{
						return false;
					}
					String otherCharacter2 = list.peek();
					if(otherCharacter2.equals("{"))
					{
						list.pop();
						continue;
					}
					break;
				case '”':
					if(list.count() == 0)
					{
						return false;
					}
					String otherCharacter3 = list.peek();
					if(otherCharacter3.equals("“"))
					{
						list.pop();
						continue;
					}
					break;
				case '>':
					if(list.count() == 0)
					{
						return false;
					}
					String otherCharacter4 = list.peek();
					if(otherCharacter4.equals("<"))
					{
						list.pop();
						continue;
					}
					break;
				default:
					break;
			}
		}
		if(list.count() == 0) //If the stack is empty at the end it returns true
		{
			return true;
		}
		else //Otherwise the string is not formatted properly
		{
			return false; 
		}
	}
}
