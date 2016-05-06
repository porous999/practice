#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int checkForPalindrome (char *str, int length)
{
	int flagForPalindrome = 1, i;
	//printf ("Checking palindrome for: (length = %d) %s", length, str);
	for (i = 0; i < length/2; i++)
	{
		if (i < length - 1 - i)
		{
			if (str[i] != str[length - i - 1])
			{
				//printf ("Breaking palindrome at: %c(%d) %c(%d)\n", str[i], i, str[length - i -1], length - i -1);
				flagForPalindrome = 0;
				break;
			}
		}
	}
	return flagForPalindrome;
}

int findPalinIndex (char *str)
{
	int length, i, j, str2_index, palinIndex = -1;
	length = strlen (str);

	//printf ("In findPalinIndex: (%d)string=%s\n", length, str);

	char *str2 = (char *) malloc (length);
	strcpy  (str2, "\0");
	for (i = -1; i < length - 1; i++)
	{
		//break;
		str2_index = 0;
		for (j = 0; j <= length; j++)
		{
			//printf ("i = %d, j = %d\n", i, j);
			if (j != i)
				str2[str2_index++] = str[j];
		}
		str2[str2_index] = '\0';
		//printf ("i = %d: %d %s", i, strlen(str2), str2);
		if (checkForPalindrome (str2, strlen(str2) - 1))
		{
			//printf ("Returning to main function for i = %d\n", i);
			return i;
		}
		//free (str2);
	}
	//free (str);
	return palinIndex;
}

int main() {

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */	
	int testCase, i, index, MAX_LENGTH = 100006;
	char *s;
	s = (char *) malloc (MAX_LENGTH);
	scanf ("%d", &testCase);
	fflush (stdin);
	for (i = 0; i < testCase; i++)
	{
		fflush (stdin);
		while (strlen(fgets (s, MAX_LENGTH, stdin)) == 1);
		//printf ("------------------\nInput string: %d = %s", strlen (s), s);
		//printf ("Output: %d\n", findPalinIndex(s));
		index = findPalinIndex(s);
		printf ("%d\n", index);
		//printf ("Output: %d\n", index);
	}
		
	return 0;
}
