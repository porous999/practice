#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int checkForPangram (char *str)
{
	int flagForPangram = 0, i, ascii_i, alphabets[26] = {0};
	int strLen = strlen (str);
	//printf ("%d\n", strLen);

	for (i = 0; i < strLen; i++)
	{
		ascii_i = str[i];
		if (ascii_i < 65)
			continue;
			
		if (ascii_i >= 97 && ascii_i <= 122)
			alphabets[ascii_i - 97] = 1;
		else if (ascii_i >= 65 && ascii_i <= 90)
			alphabets[ascii_i - 65] = 1;
	}
	for (i = 0; i < 26; i++)
		flagForPangram += alphabets[i];
	if (flagForPangram == 26)
		return 1;
	else
		 return 0;
}

int main() {

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */	
	char s[1000];
	fflush (stdin);
	fgets (s, 1000, stdin);

	if (checkForPangram (s) == 1)
		printf ("pangram\n");
	else
		printf ("not pangram\n");
		
	return 0;
}
