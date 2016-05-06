#include <stdio.h>
#include <stdlib.h>

void printArray (int *arr, int len)
{
	int i;
	for (i=0; i<len; i++)
		printf("%d ", arr[i]);
	printf ("\n");
}

void insertionSort (int *arr, int length)
{
	int value, i, j;
	for (i = 1; i < length; i++)
	{
		value = arr[i];
		/*
		for (j = i-1; j > -1; j--)
		{
			if (arr[j] > value)
				arr[j+1] = arr[j];
			else
				break;
			//printArray(arr, length);
		}
		*/
		j = i-1;
		while (j > -1 && arr[j] > value)
		{
			arr[j+1] = arr[j];
			j--;
		}
		//printf("\nvalue = %d, j = %d\n", value, j);
		arr[j+1] = value;
		printArray(arr, length);
	}
}

int main()
{

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */	
	int length, i, *arr, temp;
	scanf ("%d", &length);
	arr = (int *) malloc (4*length);
	for (i = 0; i < length; i++)
		scanf("%d", (arr+i));

	//printf("Before sorting, array = ");
	//printArray(arr, length);
	insertionSort(arr, length);
	//printArray(arr, length);
	
	return 0;
}
