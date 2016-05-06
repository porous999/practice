#include <stdio.h>
#include <stdlib.h>

void printArray (int *arr, int len)
{
	int i;
	for (i=0; i<len; i++)
		printf("%d ", arr[i]);
	printf ("\n");
}

void countSorting (int *arr, int length)
{
	int *arrCount, i, j = 0;
	arrCount = (int *) calloc (100, 4);
	for (i = 0; i < length; i++)
		arrCount[arr[i]]++;

	for (i = 0; i < 100; i++)
	{
		while (arrCount[i]--)
		{
			//printf ("Inserting %d %d times at %d\n", i, arrCount[i], j);
			arr[j++] = i;
		}
	}
	printArray (arr, length);
}

int main()
{

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */	
	int length, i, *arr, temp;
	scanf ("%d", &length);
	arr = (int *) malloc (4*length);
	for (i = 0; i < length; i++)
		scanf("%d", (arr+i));

	countSorting (arr, length);
	
	return 0;
}
