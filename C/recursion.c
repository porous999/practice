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

int main ()
{
	printf ("%d\n", sumOfAllDigits (224));
	return 0;
}
