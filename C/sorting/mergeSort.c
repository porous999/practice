#include<stdio.h>

void printArray(int *array, int i, int size)
{
	for (i; i<size; i++)
		printf("%d ", array[i]);
	printf ("\n");
}

void merge (int *array, int l, int m, int r);
void mergeSort(int *array, int index1, int index2)
{
	int length = index2 - index1;
	int midlength = index1 + length/2;

	if (length >= 1)
	{
		printf ("Before left recursion\n");
		printArray (array, index1, midlength-index1);
		printArray (array, index2, index2-midlength);
		mergeSort(array, index1, midlength);
		printf ("\n\nAfter left recursion\n");
		printArray (array, index1, midlength-index1);
		printArray (array, index2, index2-midlength);
		mergeSort(array, midlength+1, index2);
		printf ("\n\nAfter right recursion\n");
		printArray (array, index1, midlength-index1);
		printArray (array, index2, index2-midlength);
		merge(array, index1, midlength, index2);
		printf ("\n\nAfter merging recursion\n");
		printArray (array, index1, midlength-index1);
		printArray (array, index2, index2-midlength);
	}
}

void merge(int *arr, int l, int m, int r)
{
	int i, j, k;
	int n1 = m - l + 1;
	int n2 =  r - m;
 
	/* create temp arrays */
	int L[n1], R[n2];
 
	/* Copy data to temp arrays L[] and R[] */
	for(i = 0; i < n1; i++)
		L[i] = arr[l + i];
	for(j = 0; j < n2; j++)
		R[j] = arr[m + 1+ j];
 
	/* Merge the temp arrays back into arr[l..r]*/
	i = 0;
	j = 0;
	k = l;
	while (i < n1 && j < n2)
	{
		if (L[i] <= R[j])
		{
			arr[k] = L[i];
			i++;
		}
		else
		{
			arr[k] = R[j];
			j++;
		}
		k++;
	}
 
	/* Copy the remaining elements of L[], if there are any */
	while (i < n1)
	{
		arr[k] = L[i];
		i++;
		k++;
	}
 
	/* Copy the remaining elements of R[], if there are any */
	while (j < n2)
	{
		arr[k] = R[j];
		j++;
		k++;
	}
}

int main()
{
	int i;
	
	int array[10] = {5123,2353,473,3454,734,230,98,4823,821,781};
	printf ("Original array is: ");
	printArray(array, 0, 10);

	mergeSort(array, 0, 9);
	printf ("Sorted array is: ");
	printArray(array, 0, 10);
}
