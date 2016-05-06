#include <stdio.h>
#include <stdlib.h>

int main() {

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */	
	int value, length, i, *arr, loc;
	scanf ("%d", &value);
	scanf ("%d", &length);
	arr = (int *) malloc (4*length);
	for (i = 0; i < length; i++)
		scanf("%d", (arr+i));

	for (i = 0; i < length; i++)
	{
		if (*(arr + i) == value)
			break;
	}
	printf ("%d", i);
	return 0;
}
