# include <stdio.h>
# include <stdlib.h>
# include <string.h>

char nonRepeat (char *str)
{
	int length, i, j, freq[26]={0};
	length = strlen (str);
	//freq = (int *) malloc (4*length);
	//nonRepeat = inputStr [index];
	for (i = 0; i < length; i++)
	{
		j = (int) (str[i]);
		// A-Z 65 - 90
		// a-z 97-122
		if (j < 92)
			j = j - 65;
		else
			j = j - 97;
		
		freq[j]++;
	}
	for (i = 0; i < length; i++)
	{
		j = (int) (str[i]);
		// A-Z 65 - 90
		// a-z 97-122
		if (j < 92)
			j = j - 65;
		else
			j = j - 97;
		if (freq[j] == 1)
			return str[i];
	}
}

int main ()
{
	char inputStr[20], out;
	
	//nonRepeat = '0';
	printf ("Enter the input string: ");
	gets (inputStr);
	
	out = nonRepeat (inputStr);
	
	printf ("%c\n", out);
}
