/* LeetCode 299 - Bulls and Cows
 * Problem: You have a number and your friend must guess that number. Each guess, you must
 * give your friend a hint that indicates how many digits in the guess match the secret number.
 * The 'match' must be indicated two ways: 1) Bulls - correct digit in correct place or 2) Cows
 * - amount of correct digits in wrong position. 
   Task: write a function that returns the hint according to the matching indications */

class BullsAndCows
{
	public String getHint(String secret, String guess)
	{
		int[] counts = new int[10];
		int num = 0;
		int numg = 0;

		for(int i = 0; i < secret.length(); i++)
		{
			num = (int) secret.charAt(i) - 48;
			counts[num] += 1;
		}

		int B = 0; // bulls
		int C = 0; //cows

		for(int i = 0; i < guess.length(); i++)
		{
			num = (int) secret.charAt(i) - 48;
			numg = (int) guess.charAt(i) - 48;

			if(num == numg)
			{
				if(counts[num] > 0 ) counts[num] -= 1;
				else C -= 1;
				B += 1;
			}
			else
			{
				if(counts[numg] > 0)
				{
					C += 1;
					counts[numg] -= 1;
				}
			}
		}
		return A + "A" + B + "B";
	}
}
