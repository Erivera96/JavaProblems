// LeetCode # 263: Write a program to check whether a given number is an ugly number.
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

#include <stdio.h>

int main()
{
	int num = 4125;
	printf("Is %d an ugly number?\n",num);	

	while(num > 1)
	{
		if(num % 5 == 0) num /= 5;
		if(num % 3 == 0) num /= 3;
		if(num % 2 == 0) num /= 2;
		if(num % 5 != 0 && num % 3 != 0 && num % 2 != 0) break;
	}
	
	if(num == 1) printf("true\n");
	else printf("false\n");
	
	return 0;
}
