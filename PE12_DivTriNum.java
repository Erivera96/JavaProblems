import java.math.*;
import java.util.Scanner;

public class DivTriNum
{
	/*
	 * Project Euler # 12: Highly Divisible Triangular Number
	 * A triangle number is the sum of all numbers before that number (including itself).
	 * The 7th triangular number (tri(7)) is 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
	 * Each triangular number has a certain amount of divisors, it so happens 28 is the first to have 5 divisors.
	 * Goal: Find the first triangular number to have over 500 divisors.
	 */

	// First find the triangular number, then find how many divisors it has
	public static int DivCounter(int n)
	{
		int divCount = 0;
		int triNum = 0;

		for(int i = 1; divCount <= n+1; i++)
		{
			triNum = (int) (Math.pow(i,2) + i)/2;
			divCount = 0;

			for(int j = 1; j <= (int) Math.sqrt(triNum); j++)
			{
				if(triNum % j == 0) divCount += 2;
			}
		}
		return triNum;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Specify the number of divisors you wish to find the triangle number of: ");
		int n = input.nextInt();
		int ans = DivCounter(n);
		System.out.println("The triangle number with more than " + n + " divisors is: " + ans);
	}
} 
