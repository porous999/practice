#include<stdio.h>

int quickSort(int *array, int index1, int index2, int origLength)
{
	int temp, i;
	int pivotIndex = index2;
	int firstIndex = index1;
	int lastIndex = index2;

	if (index1 < index2)
	{
		//printf("********************\n");
		while (index1 < index2)
		{
			// move index to right from the first index till find a value at index greater than value at pivotIndex
			while (array[index1] <= array[pivotIndex] && index1 <= lastIndex)
				index1++;
			// move index to left from the last index till find a value at index lesser than or equal to value at pivotIndex
			while (array[index2] > array[pivotIndex])
				index2--;

			//swap the values
			if (index1 < index2)
			{
				//printf("Swapping %d and %d with pivot at %d\n", index1,index2,pivotIndex);
				temp = array[index1];
				array[index1] = array[index2];
				array[index2] = temp;
			}
		}

		//printf ("\nindex1=%d index2=%d firstIndex=%d lastIndex=%d\n",index1,index2,firstIndex,lastIndex);

		//swap the value at index2 with the value at pivotIndex
		//printf("Swapping %d and pivot(%d)\n", index2,pivotIndex);
		temp = array[index2];
		array[index2] = array[pivotIndex];
		array[pivotIndex] = temp;
		
		for ( i = 0; i<origLength; i++)
			printf("%d ", array[i]);
		printf ("\n");
		quickSort(array, firstIndex, index2-1, origLength);
		quickSort(array, index2+1, lastIndex, origLength);
	}
}

int main()
{
	int i;
	
	//int array[10] = {5123,2353,473,3454,734,230,98,4823,821,781};
	int _ar_size = 7;
        scanf("%d", &_ar_size);
        int _ar[_ar_size], _ar_i;
        for(_ar_i = 0; _ar_i < _ar_size; _ar_i++)
                scanf("%d", &_ar[_ar_i]);

	//printf ("Original array is: ");

	quickSort(_ar, 0, _ar_size - 1, _ar_size);
	//printf ("Sorted array is: ");
	//printf ("\n");
}
