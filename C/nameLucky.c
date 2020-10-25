# include <stdio.h>
# include <stdlib.h>
# include <string.h>

int sumOfAllDigits (int num)
{
	int sum = 0, digits;
	if (!num)
		return num;
	else
	{
		digits = num % 10;
		num = sumOfAllDigits (num / 10) + digits;
	}
	return num;
}

int getLucky (int luckySum)
{
	printf ("ASCII val: %d\n", luckySum);
	if (luckySum < 10)
		return luckySum;
	else
	{
		luckySum = sumOfAllDigits (luckySum);
		luckySum = getLucky (luckySum);
	}
	return luckySum;
}

int main ()
{
	int luckyNum, strASCII, i = 0;
	char *newStr;
	newStr = (char *) malloc (40);
	printf ("Enter the string: ");
	scanf ("%s", newStr);
	printf ("String is: %s\n", newStr);
	strASCII = 0;
	
	for (i = 0; i < strlen (newStr); i++)
	{
		strASCII += (int) newStr[i];
//		printf ("%c==>%d\t", newStr[i], (int) newStr[i]);
//		printf ("Sum so Far: %d\n", strASCII);
	}

	luckyNum = getLucky (strASCII);
	printf ("Lucky Number is: %d\n", luckyNum);
	return 0;
}
