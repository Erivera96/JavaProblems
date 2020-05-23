#include <stdio.h>
void islcntr(int x[4][5]);
void print(int x[4][5]);

int main()
{
	int a[4][5] = { {1, 1, 1, 1, 1}, 
		        {1, 1, 0, 0, 0}, 
			{1, 0, 1, 1, 0}, 
			{0, 0, 0, 0, 1} };
	islcntr(a);
	printf("\n");
	print(a);
	return 0;
}

void islcntr(int x[4][5])
{
	int islcntr = 0;
	bool bor = false;

	for(int i = 0; i < 4; i++)
	{
		if(x[i][j] == 1)
		{
			islcntr++;
			for(int j = i+1; j < 5;)
			{
				
			}	
		}
	}
}

void print(int x[4][5])
{
	printf("   0 1 2 3 4\n");
	for(int i = 0; i < 4; i++)
	{
		printf("%d| ",i);
		for(int j = 0; j < 5; j++)
		{
			printf("%d ",x[i][j]);
		}
		printf("\n");
	}
}

