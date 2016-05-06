#include <stdio.h>
#include <stdlib.h>

void printArray (int *arr, int i, int length)
{
	length = i + length;
	for (i; i < length; i++)
		printf ("%d ", arr[i]);
	printf ("\n");
}

void partition (int leftIndex, int rightIndex, int *ar)
{
	//printf ("\n****\nEntering funtion:\nleftIndex = %d rightIndex = %d\n", leftIndex, rightIndex);
	int p = ar[leftIndex], i;
	int ar_size = rightIndex - leftIndex + 1;
	int arLeft[ar_size], arRight[ar_size];
	int arLeft_size = 0, arRight_size = 0;

	/*
	if (ar_size == 2)
	{
		if (ar[leftIndex] > ar[rightIndex])
		{
			//printf ("Swapped %d and %d here!!!\n", ar[leftIndex], ar[rightIndex]);
			ar[leftIndex] = ar[leftIndex] + ar[rightIndex];
			ar[rightIndex] = ar[leftIndex] - ar[rightIndex];
			ar[leftIndex] = ar[leftIndex] - ar[rightIndex];
		}
		printArray(ar, leftIndex, ar_size);
		return;
	}
	*/
	for (i = leftIndex + 1; i < rightIndex + 1; i++)
	{
		if (ar[i] < p)
		{
			//printf ("Inserting %d in left array at %d\n", ar[i], arLeft_size);
			arLeft[arLeft_size++] = ar[i];
		}
		else
		{
			//printf ("Inserting %d in right array at %d\n", ar[i], arRight_size);
			arRight[arRight_size++] = ar[i];
		}
	}
	
	//printf ("---Inserting in array:\n");
	//printf ("arLeft_size =  %d arRight_size = %d\n", arLeft_size, arRight_size);
	//printf ("leftIndex = %d rightIndex = %d\n", leftIndex, rightIndex);
	for (i = leftIndex; i < leftIndex + arLeft_size; i++)
	{
		//printf ("Inserting %d in array at %d from arLeft[%d]\n", arLeft[i - leftIndex], i, i - leftIndex);
		ar[i] = arLeft[i - leftIndex];
	}
	//printf ("Inserting %d in array at %d\n", p, i);
	ar[i] = p;
	for (i = i + 1; i < rightIndex + 1; i++)
	{		
		//printf ("Inserting %d in array at %d from arRight[%d]\n", arRight[i - leftIndex - arLeft_size - 1], i, i - leftIndex - arLeft_size - 1);
		ar[i] = arRight[i - leftIndex - arLeft_size - 1];
	}
		
	//printf ("\nArray before calling recursion:\n");
	//printArray(ar);
	if (arLeft_size > 1)
	{	
		//printf ("Calling left recursion on: leftIndex = %d rightIndex = %d\n", leftIndex, leftIndex + arLeft_size - 1);
		partition (leftIndex, leftIndex + arLeft_size - 1, ar);
	}
	if (arRight_size > 1)
	{
		//printf ("Calling right recursion on: leftIndex = %d rightIndex = %d\n", leftIndex + arLeft_size + 1, rightIndex);
		partition (leftIndex + arLeft_size + 1, rightIndex, ar);
	}
	printArray (ar, leftIndex, ar_size);
}

void quicksort (int length, int *arr)
{
	partition (0, length-1, arr);
	//printArray (arr, length);
}

int main(void)
{
	 
	int _ar_size = 7;
	scanf("%d", &_ar_size);
	int _ar[_ar_size], _ar_i;
	for(_ar_i = 0; _ar_i < _ar_size; _ar_i++)
		scanf("%d", &_ar[_ar_i]); 
	//printArray(_ar, _ar_size);
	quicksort (_ar_size, _ar);
	//printArray(_ar, 0, _ar_size);
	 
	return 0;
}
