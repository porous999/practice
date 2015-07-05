# include <stdio.h>

int main ()
{
	int a, b, temp;
	a = 10;
	b = 20;

	void swap (x = &a, y = &b)
	{
		temp = *x;
		*x = *y;
		*y = temp;
	}
	printf ("%d, %d\n", a, b);
	return 0;
}
