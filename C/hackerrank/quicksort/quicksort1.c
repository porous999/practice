#include <stdio.h>
#include <stdlib.h>

void printArray (int *arr, int len)
{
	int i;
	for (i=0; i<len; i++)
		printf("%d ", arr[i]);
	printf ("\n");
}

void partition(int ar_size, int *ar)
{
	int p = ar[0], i;
	int arLeft[ar_size], arRight[ar_size];
	int arLeft_size = 0, arRight_size = 0;

	for (i = 1; i < ar_size; i++)
	{
		if (ar[i] < p)
			arLeft[arLeft_size++] = ar[i];
		else
			arRight[arRight_size++] = ar[i];
	}

	for (i = 0; i < arLeft_size; i++)
		ar[i] = arLeft[i];
	ar[i] = p;
	for (i = i + 1; i < ar_size; i++)
		ar[i] = arRight[i - arLeft_size - 1];
		
	printArray(ar, ar_size);
}

int main(void)
{
	 
	 int _ar_size;
	scanf("%d", &_ar_size);
	int _ar[_ar_size], _ar_i;
	for(_ar_i = 0; _ar_i < _ar_size; _ar_i++)
		scanf("%d", &_ar[_ar_i]); 
	partition(_ar_size, _ar);
	 
	return 0;
}

