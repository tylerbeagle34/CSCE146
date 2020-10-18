
public class SimpleRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//countdown(5);
		//System.out.println(factorial(5));
		//System.out.println(gcd(33, 44));
		System.out.println(fibbo(10));
	}
	public static void countdown(int num)
	{
		System.out.println(num);
		if(num <= 0) //Halting condition
		{
			return;
		}
		else
		{
			countdown(num - 1); //Recursive call
		}
	}
	public static int factorial(int num)
	{
		if(num == 1)
		{
			return 1;
		}
		else
		{
			return num * factorial(num - 1);
			//return num * factorial(num --); //NOT THE SAME
		}
	}
	public static int gcd(int num1, int num2)
	{
		if(num2 == 0)
		{
			return num1;
		}
		else
		{
			return gcd(num2, num1 % num2);
		}
	}
	public static int fibbo(int pos)
	{
		if(pos == 1 || pos == 2)
		{
			return 1;
		}
		else
		{
			return fibbo(pos - 1) + fibbo(pos - 2);
		}
	}
}
