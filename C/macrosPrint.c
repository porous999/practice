# include "stdio.h"

#define firstExec() { printf ("Helllo\n");}

int before_main ()
{
	printf ("Second before main\n");
    return 0;
}

#define static int n = before_main ();

int main ()
{
	firstExec ();
	printf ("Main\n");
	return 0;
}
