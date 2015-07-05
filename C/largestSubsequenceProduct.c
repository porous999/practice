/*
Finding out the maximum contiguous subsequence product in an array.
Subsequence whose product is max in an array.
*/

# include <stdio.h>
# include <stdlib.h>

int *find_max_prod_subsequence (int array);

void print_array (int *array, int start, int length)
{
	int i = start;
	printf ("The array requested is:\n")
	for (i; i < length; i++)
	{
		printf ("%d\n", array[i]);
	}
}

int *input_array (int *array, int length)
{
	int i;
	array = (int *) malloc (4 * length);
	printf ("Enter elements one by one:\n");
	for (i = 0; i < length; i++)
	{
		scanf ("%d", (array + i));
	}
	return array;
}

int main ()
{
	//int newArray[20] = {12,74,54,91,76,21,47,32,8,63};
	int *newArray, length, *max_prod;
	printf ("Enter length of array:\n");
	scanf ("%d", &length);

	newArray = input_array (newArray, length);
	max_prod = find_max_prod_subsequence (newArray, max_prod);
	length = max_prod[1] - max_prod[0] + 1;
	print_array (array, max_prod[0], length);
	return 0;
}
