#include <stdio.h>

void main ()
{
	int x = 8;
	x-= (--x) - (x--);
	printf ("%d\n", x);
}
