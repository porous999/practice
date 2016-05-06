#include <stdio.h>
#include <stdlib.h>

void printArray(int *arr, int len)
{
	int i;
	for (i=0; i<len; i++)
		printf("%d ", arr[i]);
	printf ("\n");
}

int main() {

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */	
	int length, i, *arr, temp;
	scanf ("%d", &length);
	arr = (int *) malloc (4*length);
	for (i = 0; i < length; i++)
		scanf("%d", (arr+i));
	
	int value = arr[length-1];
	for (i = length-2; i > -1; i--)
	{
		if (arr[i] > value)
			arr[i+1] = arr[i];
		else
			break;
		printArray(arr, length);
	}
	arr[i+1] = value;
	printArray(arr, length);
	return 0;
}
