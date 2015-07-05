/*
HERE WE COME TO KNOW THAT STRTOK ACTUALLY MODIFIES THE STRING
*/

# include <stdio.h>
# include <stdlib.h>
# include <string.h>

int countNumOfWords (char *strNew)
{
	char *words;
	int totalNumOfWords = 0;
	words = strtok (strNew, " .,");
	printf ("Counting words\n");
	while (words)
	{
		totalNumOfWords++;
		//start = createWordNodes (start, last, words);
		printf ("%s----", words);
		words = strtok (NULL, " .,");
	}
	return totalNumOfWords;
}

char *getWords(char *strNew, int numOfWords, char **words)
{
	int i;
	char *eachWord;
	words = (char **) malloc (sizeof (char *) * numOfWords);
	eachWord = strtok (strNew, " .,");
	for (i = 0; i < numOfWords; i++)
	{
		*(words + i) = (char *) malloc (15);
		*(words + i) = strcpy (*(words + i), eachWord);
		eachWord = strtok (NULL, " .,");
	}
	return words;
}

int main ()
{
	//char strNew[20] = "This is very new";
	char *strNew, *strCopy;
	strNew = (char *) malloc (20);
	strNew = strcpy (strNew, "This is very new");
	strCopy = (char *) malloc (20);
	strCopy = strcpy (strCopy, "This is very new");

	char delims[2] = " ";
	char **words;
	int numOfWords;
	//strtok ();
	//*strNew = '\0';
	/*printf ("%s\n", strtok(strNew, delims));
	printf ("%s\n", strtok(strNew, delims));
	printf ("%s\n", strtok(NULL, delims));
	//printf ("%s\n", strtok(strNew, delims));
	printf ("%s\n", strtok(NULL, delims));
	//free (strNew);
	//strNew = '\0';
	//printf ("%d\n", strlen (strNew));
	*/
	printf ("Before string tokenize: %s\n", strNew);
	numOfWords = countNumOfWords (strNew);
	printf ("After string tokenizing, num of words: %d\nAnd string is: %s\n", numOfWords, strNew);
/*
	words = getWords (strCopy, numOfWords, words);
	printf ("Came here");
	int i;
	for (i = 0; i < numOfWords; i++)
	{
		printf ("%s\n", *(words + i));
	}
*/
	return 0;
}
