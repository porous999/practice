class MultTable
{
	final static int rows = 10, columns = 10;
	public static void main (String args[])
	{
		int i, j;
		int product[][];
		product = new int[rows][columns];
		for (i = 1; i < 11; i++)
		{
			for (j = 1; j < 11; j++)
			{
				product[i-1][j-1] = i * j;
			}
		}
		for (i = 0; i < 10; i++)
		{
			for (j = 0; j < 10; j++)
			{
				System.out.print (product[i][j] + "\t");
			}
			System.out.println ();
		}
	}
}
