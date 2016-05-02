#include<stdio.h>
#include<stdlib.h>

int **fillArray (int **arr, int m, int n)
{
	int i, j, ele;
	arr = (int **) malloc (sizeof(int *)*m);
	for (i = 0; i < m; i++)
		*(arr + i) = (int *) malloc (sizeof(int)*n);
	
	//printf ("Enter elements: ");
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			scanf ("%d", &ele);
			fflush(stdin);
			//printf ("The element to be inserted in (%d,%d) is %d !\n", i, j, ele);
			*(*(arr + i) + j) = ele;
		}
	}
	return arr;
}

void printArray (int **arr, int m, int n)
{
	int i, j;
	
	printf ("\nThe array now is: \n");
	
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
			printf ("%d ", *(*(arr + i) + j));
		printf ("\n");
	}
		
}

int countNegativeNumbers(int **arr, int m, int n);

void main ()
{
	int **arr, m, n;
	
	printf ("Enter rows of array: ");
	scanf ("%d", &m);
	
	printf ("Enter columns of array: ");
	scanf ("%d", &n);
	
	printf ("\n");
	
	arr = fillArray (arr, m, n);
	printArray(arr, m, n);
	
	printf ("Number of negative elements are: %d\n", countNegativeNumbers (arr, m, n));
}

int countNegativeNumbers(int **arr, int m, int n)
{
	int i, j = n - 1;
	int numberOfLoops = 0;
	int negativeCount = 0;
	
	for (i = 0; i < m; i++)
	{
		while (*(*(arr + i) + j) >= 0 & j-- >= 0)
			numberOfLoops++;
		negativeCount = negativeCount + j + 1;
		numberOfLoops++;
	}
	printf ("After %d loops, we get the response!\n", numberOfLoops);
	return negativeCount;
}
