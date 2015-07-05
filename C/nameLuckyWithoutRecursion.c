# include <stdio.h>
# include <stdlib.h>
# include <string.h>

int sumOfAllDigits (int num)
{
	int sum = 0, digits;

	while (num)
	{
		sum += num % 10;
		num = num / 10;
	}
	return sum;
}

int getLucky (int luckySum)
{
	printf ("ASCII val: %d\n", luckySum);
	while (luckySum > 9)
	{
		luckySum = sumOfAllDigits (luckySum);
	}
	return luckySum;
}

int main ()
{
	int luckyNum, strASCII, i = 0;
	char *newStr;
	newStr = (char *) malloc (40);
//	newStr = "Ina Purkayastha";
	printf ("Enter the string:");
	scanf ("%s", newStr);
	printf ("String is: %s\n", newStr);
	strASCII = 0;

	for (i = 0; i < strlen (newStr); i++)
	{
		strASCII += (int) newStr[i];
//		printf ("%d==>%d\t", newStr[i], (int) newStr[i]);
//		printf ("Sum so Far: %d\n", strASCII);
	}

	luckyNum = getLucky (strASCII);
	printf ("Lucky Number is: %d\n", luckyNum);
	return 0;
}
