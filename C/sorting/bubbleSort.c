#include<stdio.h>

void printArray (int *array, int size)
{
	int temp;
	for (temp = 0; temp<size; temp++)
		printf("%d ", array[temp]);
	printf ("\n");
}

void bubbleSort(int *array, int len)
{
	int i, j, temp;

	for (i = 0; i < len-2; i++)
	{
		printf ("\ni=%d\n", i);
		for (j = 0; j < len-i-1; j++)
		{
			printf ("Checking %d and %d\n", j, j+1);
			if (array[j] > array[j+1])
			{
				printf ("Swapping %d and %d\n", j, j+1);
				temp = array[j+1];
				array[j+1] = array[j];
				array[j] = temp;
			}
			printArray (array, 10);
		}
	}
}

int main ()
{
	int i;

        int array[10] = {5123,2353,473,3454,734,230,98,4823,821,781};
        printf ("Original array is: ");
        printArray (array, 10);

        bubbleSort(array, 10);
        printf ("Sorted array is: ");
        printArray (array, 10);
}
