/* LeetCode 647 - Palindromic Substrings
 * Task: Given a string, count how many palindromic substrings are in the string.
 * The substrings with different start indexes or end indexes are counted as different
 * substrings even if they consist of the same characters */

class PaliSubstr
{
	public static int expand(String s, int i , int j)
	{
		int retval = 0;
		int len = s.length();

		while(i > -1 && j < len)
		{
			if(s.charAt(i) != s.charAt(j)) return retval;
			else
			{
				i--;
				j++;
				retval++;
			}
		}
		return retval;
	}

	public int countSubstrings(String s)
	{
		int retval = s.length();

		for(int i = 0; i < s.length()-1; i++)
		{
			retval += expand(s, i-1, i+1);
			if(s.charAt(i) == s.charAt(i+1)) retval += (expand(s, i-1, i+2) + 1);
		}
		return retval;
	}
}
