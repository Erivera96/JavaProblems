import java.math.*;
import java.util.Scanner;

public class NumSpiDiag
{
	/*
	 * Project Euler # 28: Number Spiral Diagonals
	 * Start with 1 and spiral outward in a clockwise direction.
	 * For a 5x5 matrix you get:
	 * 21 22 23 24 25
	 * 20  7  8  9 10
	 * 19  6  1  2 11
	 * 18  5  4  3 12
	 * 17 16 15 14 13
	 * The numbers on the diagonals are: 1, 3, 5, 7, 9, 13, 17, 21, 25
	 * The sum of the numbers on the diagonals is 101.
	 * Goal: By constructing the matrix in the same way, find the sum
	 * of the diagonals for a 1001 x 1001 matrix.
	 */

	public static void main(String[] args)
	{
		
		double Tstart = System.nanoTime();
		// Initialize all the variables that will be needed.
		int dimensions = 1001;
		int amount = (int) Math.pow(dimensions,2);	
		int start = (dimensions-1)/2;
		int[][] b = new int[dimensions][dimensions];
		int iterator = 0, iterationCounter = 1, row = start, column = start, number = 1;
		// Add the first element to the matrix
		b[row][column] = number++;
		
		while(iterationCounter <= dimensions)
		{
			// Iterate forwards through the column & row, 
			// iterationCounter amount of times
			// (This goes right and down)
			iterator = 0;
			while(iterator < iterationCounter)
			{
				if(column == dimensions-1) break; 
				b[row][++column] = number++;
				iterator++;
			}
			// This would be when the very last element was added,
			// the matrix would be complete.
			if((row == 0) && (column == dimensions-1)) break;
			iterator = 0;
			while(iterator < iterationCounter)
			{
				b[++row][column] = number++;
				iterator++;
			}

			iterationCounter++;
			
			// Iterate backwards through the column & row, 
			// iterationCounter amount of times
			// (This goes left and up)
			iterator = 0;
			while(iterator < iterationCounter)
			{
				b[row][--column] = number++;
				iterator++;
			}
			iterator = 0;
			while(iterator < iterationCounter)
			{
				b[--row][column] = number++;
				iterator++;
			}
			iterationCounter++;	
		}	
		double total = (System.nanoTime() - Tstart)/1e6;
		System.out.println("Spiraling Matrix took " + total + " milliseconds to construct.");
		/*	
		System.out.println("\nPRINTING MATRIX\n");	
		for(int i = 0; i < b.length; i++)
		{
			for(int j = 0; j < b[i].length; j++)
			{
				System.out.printf("%-4s",b[i][j]);
			}
			System.out.println();
		}
		*/
		Tstart = System.nanoTime();
		int sum = 0;
		for(int i = 0, j = 0, k = dimensions-1; i < b.length; i++,j++, k--)
		{
			sum += b[i][j]; // When indices are the same (forward diagonal) add that number to sum
			if(k != j) sum += b[k][i]; // This traverses the counter diagonal (only when j and k are not the same, to avoid duplicates)
		}
		total = (System.nanoTime() - Tstart)/1e6;
		System.out.println("Finding the sum (" + sum + ") of the diagonals took " + total + " milliseconds to compute.");
	}
}
