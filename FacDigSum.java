import java.math.BigInteger;
import java.util.Scanner;

public class FacDigSum
{
	/* 
	 * Project Euler # 20: Factorial Digit Sum
	 * n! means n * (n-1) * (n-2) * ... * 3 * 2 * 1
	 * 10! is 3628800, its factorial digit sum means
	 * 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27
	 * Goal: Find the factorial digit sum for 100!
	 */

	// Compute the factorial for the given number
	public static BigInteger factorial(BigInteger n)
	{
		return n.equals(BigInteger.ONE) ? BigInteger.ONE :  n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}

	// Break the number into individual digits and sum them up
	public static BigInteger digitSum(BigInteger digit)
	{
		int length = digit.toString().length();
		BigInteger sum = BigInteger.ZERO;
					
		for(int i = 0; i < length; i++)
		{
			if(digit.mod(BigInteger.TEN).equals(BigInteger.ZERO))  digit = digit.divide(BigInteger.TEN);
			
			if(!digit.mod(BigInteger.TEN).equals(BigInteger.ZERO))
			{
				sum = sum.add(digit.mod(BigInteger.TEN));
				digit = digit.subtract(digit.mod(BigInteger.TEN));
			}
		}
		return sum;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter integer to find factorial digit sum: ");
		
		BigInteger n = BigInteger.valueOf(input.nextInt());
		BigInteger facans = factorial(n);
		System.out.println(n + "! is " + facans);
		BigInteger ans = digitSum(facans);
		
		System.out.println("And the digit sum for " + facans + " is " + ans);
	}
}

