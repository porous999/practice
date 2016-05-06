#include <stdio.h>
#include <stdlib.h>

void printArray(int *arr, int len)
{
	int i;
	for (i=0; i<len; i++)
		printf("%d ", arr[i]);
	printf ("\n");
}

void countingSorting (int *arr, int length)
{
	int *arrCount, i;
	arrCount = (int *) calloc (100, 4);
	for (i = 0; i < length; i++)
		arrCount[arr[i]]++;
	printArray(arrCount, 100);
}

int main()
{

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */	
	int length, i, *arr, temp;
	scanf ("%d", &length);
	arr = (int *) malloc (4*length);
	for (i = 0; i < length; i++)
		scanf("%d", (arr+i));

	countingSorting (arr, length);
	
	return 0;
}
