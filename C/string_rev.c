#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *reverse(char *str)
{
	char temp[20];
	if (str)
	{
		//temp = reverse (str+1);
		strcat (reverse (str+1), str);
	}
	return str;
}

int main ()
{
	char *str;
	str=(char *)malloc(sizeof(char)*20);
	strcpy(str, "TanmaY");
	//str = reverse (str);
	printf ("%s\n", str);
	return 0;
}
