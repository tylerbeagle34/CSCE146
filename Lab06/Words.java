/*
 * Written by Warren Beagle
 * Lab06: Contained Words
 */
import java.util.Scanner;
public class Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in); //Allows input
		System.out.println("Enter 2 words.  I will determine if the letters of one is contained in the other");
		String input1 = keyboard.nextLine(); //First word
		String input2 = keyboard.nextLine(); //Second word
		System.out.println(input1 + "\n" + input2); //Prints the input words
		contained(input1, input2, 0, 0, 0); //Runs the contained recursion method
	}
	//Method
	public static void contained(String w1, String w2, int num1, int num2, int count)
	{
		if(w1.length() > w2.length()) //Length of the first word is greater than the second word
		{
			System.out.println("They are not contained"); //Not contained
			return;
		}
		else if(w1.length() == 0 && w2.length() == 0) //Both null
		{
			System.out.println("They are contained"); //Contained
			return;
		} 
		else
		{
			if(w1.charAt(num1) == w2.charAt(num2)) //Characters are the same
			{
				count = count + 1;
				if(count >= w1.length()) //Number of contained letters equals the length of the first word
				{
					System.out.println("They are contained"); //Contained
					return;
				}
				else
				{
					num1 = num1 + 1; //Go to next character of the first word
					/*if(w1.charAt(num1) == w1.charAt(num1 - 1))
					{
						System.out.println("They are not contained");
						return;
					}*/
					if(num1 > w1.length()) //Character index greater than the length of the first word
					{
						System.out.println("They are not contained"); //Not contained
						return;
					}
					else
					{
						contained(w1, w2, num1, num2, count); //Run the contained method for the new character index values
					}
				}
			}
			else
			{
				num2 = num2 + 1; //Go to the next character of the second word
				if(num2 >= w2.length()) //Character index greater than or equal to the length of the second word
				{
					num2 = 0; //Set the index value back to 0
					if(num1 == num2) //If the index values of the words are the same again
					{
						System.out.println("They are not contained"); //Not contained
						return;
					}
					else
					{
						contained(w1, w2, num1, num2, count); //Run the contained method for the new character index values
					}
				}
				else
				{
					contained(w1, w2, num1, num2, count); //Run the contained method for the new character index values
				}
			}
		}
	}
}
