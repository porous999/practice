#include <stdio.h>
#include <stdlib.h>

void printArray (int *arr, int len)
{
	int i;
	for (i=0; i<len; i++)
		printf("%d ", arr[i]);
	printf ("\n");
}

int insertionSort (int *arr, int length)
{
	int value, i, j, count = 0;
	for (i = 1; i < length; i++)
	{
		value = arr[i];
		j = i-1;
                while (j > -1 && arr[j] > value)
                {
                        arr[j+1] = arr[j];
			count++;
                        j--;
                }
		arr[j+1] = value;
	}
	return count;
}

int main()
{

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */	
	int length, i, *arr, temp;
	scanf ("%d", &length);
	arr = (int *) malloc (4*length);
	for (i = 0; i < length; i++)
		scanf("%d", (arr+i));

	temp = insertionSort(arr, length);
	printf("%d", temp);
	
	return 0;
}
