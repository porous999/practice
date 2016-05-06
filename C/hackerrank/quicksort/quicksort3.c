#include <stdio.h>
#include <stdlib.h>

void printArray (int *arr, int leftIndex, int length)
{
	length = leftIndex + length;
	for (leftIndex; leftIndex < length; leftIndex++)
		printf ("%d ", arr[leftIndex]);
	printf ("\n");
}

void partition (int leftIndex, int rightIndex, int *ar, int length)
{
	//printf ("\n****\nEntering funtion:\nleftIndex = %d rightIndex = %d\n", leftIndex, rightIndex);
	int p = ar[rightIndex], temp;
	int smallIndex = leftIndex, largeIndex = leftIndex;
	int ar_size = rightIndex - leftIndex + 1;

	if (rightIndex > leftIndex)
	{
		for (smallIndex = leftIndex; smallIndex < rightIndex; smallIndex++)
		{
			//printf ("Considering ar[%d] = %d and ar[%d] = %d\n", smallIndex, ar[smallIndex], largeIndex, ar[largeIndex]);
			if (ar[smallIndex] <= p)
			{
				printf ("Swapping ar[%d] = %d and ar[%d] = %d\n", smallIndex, ar[smallIndex], largeIndex, ar[largeIndex]);
				temp = ar[smallIndex];
				ar[smallIndex] = ar[largeIndex];
				ar[largeIndex] = temp;
				largeIndex++;
			}
		}
		printf ("Swapping p = %d and ar[%d] = %d\n", p, largeIndex, ar[largeIndex]);
		
		temp = ar[largeIndex];
		ar[largeIndex] = ar[rightIndex];
		ar[rightIndex] = temp;
	
		printArray (ar, 0, length);
		partition (leftIndex, largeIndex - 1, ar, length);
		partition (largeIndex + 1, rightIndex, ar, length);
		//printArray (ar, 0, ar_size);
	}
}

void quicksort (int length, int *arr)
{
	partition (0, length-1, arr, length);
	//printArray (arr, length);
}

int main()
{
	 
	int _ar_size = 7;
	//int _ar[] = {1, 3, 9, 8, 2, 7, 5}, _ar_i;
	///*
	scanf("%d", &_ar_size);
	int _ar[_ar_size], _ar_i;
	for(_ar_i = 0; _ar_i < _ar_size; _ar_i++)
		scanf("%d", &_ar[_ar_i]);
	//*/
	//printArray(_ar, 0, _ar_size);
	quicksort (_ar_size, _ar);
	//printArray(_ar, 0, _ar_size);
	 
	return 0;
}
