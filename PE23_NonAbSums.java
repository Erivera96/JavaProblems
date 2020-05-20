import java.math.*;
import java.util.*;

public class NonAbSums
{
	/* 
	 * Project Euler # 23: Non-Abundant Sums
	 * An abundant number is one whose proper divisors sum up to more than the number itself.
	 * The example being 12, whose divisors are 1,2,3,4,6. The sum of those divisors is 16 (greater than 12).
	 * Any integer greater than 28123 can be represented by a sum of two abundant numbers.
	 * Goal: Find all the integers that cannot be represented as a sum of two abundant numbers (numbers < 28123).
	 */

	// Finds the divisors and adds them up
	public static int DivSums(int n)
	{
		int divSum = 0;

		for(int i = 1; i <= n; i++)
		{
			if(n % i == 0 && i != n) divSum += i;
		}
		return divSum;
	}

	// Define abundant numbers and store them (abNums), later sum the abundant numbers and store those < 28123
	public static HashSet<Integer> AbSums(int n)
	{
		ArrayList<Integer> abNums = new ArrayList<Integer>();
		HashSet<Integer> abSums = new HashSet<Integer>();

		for(int i = 0, index = 0; i < n; i++)
		{
			if(DivSums(i+1) > i+1)
			{
				abNums.add(index,i+1);
				
				for(int j = 0; j <= index; j++)
				{
					if( (abNums.get(index) + abNums.get(j)) <= n) abSums.add(abNums.get(index) + abNums.get(j));
				}
				index++;
			}
		}
		return abSums;
	}
	
	// Remove abundant numbers from a list of numbers (1-28123), sum up those numbers to get answer
	public static int notAbSumsSUM(int n)
	{
		HashSet<Integer> abs = AbSums(n);
		HashSet<Integer> nabs = new HashSet<Integer>();
		int SUM = 0;
		
		for(int i = 1; i <= n; i++)
		{
			nabs.add(i);
		}
		nabs.removeAll(abs);
		
		Iterator<Integer> iterator = nabs.iterator();
		
		while(iterator.hasNext()) SUM += iterator.next();

		return SUM;			
	}

	public static void main(String[] args)
	{
		double start = System.nanoTime();
		System.out.println("The sum of the numbers that are non-abundant sums is: " + notAbSumsSUM(28123) + " and took " + ((System.nanoTime()-start)/1000000000) + " seconds.");
	}
}
