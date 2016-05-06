#include<stdio.h>

void insertionSort(int *array, int len)
{
	int i, j, temp;

	for (i = 0; i < len-1; i++)
	{
		for (j = i+1; j < len; j++)
		{
			printf ("Checking %d and %d\n", i, j);
			if (array[i] > array[j])
			{
				printf ("Swapping %d and %d\n", i, j);
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			for (temp = 0; temp<10; temp++)
				printf("%d ", array[temp]);
			printf ("\n");
		}
	}
}

int main ()
{
	int i;

        int array[10] = {5123,2353,473,3454,734,230,98,4823,821,781};
        printf ("Original array is: ");
        for (i = 0; i<10; i++)
                printf("%d ", array[i]);
        printf ("\n");

        insertionSort(array, 10);
        printf ("Sorted array is: ");
        for (i = 0; i<10; i++)
                printf("%d ", array[i]);
        printf ("\n");
}
