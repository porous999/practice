# include <stdio.h>

int check_perfect_square (int num)
{
	int i = 1, sum = 0, flag = 1;
	printf ("[i]  sum\tflag\n");
	while (sum <= num)
	{
		if (sum == num)
			flag = 1;
		else
			flag = 0;
		printf ("[%d]  %d\t\t%d\n", i, sum, flag);
		sum = sum + i;
		i = i + 2;
	}
	return flag;
}

int main ()
{
	int a = 1, b = 16, reply;
	reply = check_perfect_square (a);
	printf ("%d is perfect square? %d\n", a, reply);
	reply = check_perfect_square (b);
	printf ("%d is perfect square? %d\n", b, reply);
}
