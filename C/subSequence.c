#include <stdio.h>
#include<stdlib.h>
#include <string.h>

int determineSubString (char *strA, char *strB)
{
	int i, j, k;
	int strLenA, strLenB;
	int foundSubSeq = 0;
	
	strLenA = strlen (strA);
	strLenB = strlen (strB);
	
	if (strLenA < strLenB)
		return 0;
		
	for (k = 0; k < (strLenA - strLenB) + 1; k++)
	{
		j = 0;
		while (j < strLenB)
		{
			printf ("%d -- %c -- %c\n", j, strA[k+j], strB[j]);
			if (strA[k+j] != strB[j])
			{
		        	foundSubSeq = 0;
				break;
			}
			else
	   			foundSubSeq = 1;
			j++;
		}
		if (foundSubSeq == 1)
			return 1;
	}
	return foundSubSeq;
}

int main ()
{
	int ifTrue = 0;
	char *strA, *strB;
	strA = (char *) malloc (100);
	strB = (char *) malloc (100); // assuming max length 100
	scanf ("%s",strA);
	scanf ("%s", strB);
	ifTrue = determineSubString (strA, strB);
	if (ifTrue)
		printf ("True\n");
	else
		printf ("False\n");
}
