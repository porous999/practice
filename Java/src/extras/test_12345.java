package src.Extra;

class test_12345
{
	public static void main (String args[])
	{
		int i, j, k, max = 5;
		i = 1;
/*		while (i <= max)
		{
			j = 0;
			while (j++ < i)
				System.out.print (i);
			i++;
			System.out.print ("\n");
		}
*/

/*		for (i = 5; i >= 1; i--)
		{
			for (j = 1; j <= i; j++)
			{
				System.out.print ("\t" + i);
			}
			System.out.println ();
		}
*/
		for (i = 5; i >= 1; i--)
		{
			for (k = i; k < 5; k++)
				System.out.print (" ");
			for (j = 1; j <= i; j++)
			{
				//for (k = 0; k < j - 1; k++)
					//System.out.print (" ");
				System.out.print (i);
			}
			System.out.println ();
		}
	}
}
