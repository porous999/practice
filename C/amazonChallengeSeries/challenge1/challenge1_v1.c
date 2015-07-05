# include <stdio.h>
# include <stdlib.h>
# include <string.h>
# include <strings.h>

# define WORD_LENGTH 15

int checkWordIfExists (char *word, char **seqWords, int numOfWords)
{
	int flag = 0, i;
	for (i = 0; i < numOfWords; i++)
	{
		if (strcasecmp (word, *(seqWords + i)) == 0)
		{
			flag = 1;
			break;
		}
	}
	return flag;
}

void findShortestSubsequence (char *testPara, int numOfWords, char **seqWords)
{
	int i, wordExists, numOfWordsFound = 0, subSequenceLength;
	char *words, *subSequence;
	char delims[10] = " .,";

	subSequence = (char *) malloc (numOfWords * 15 + numOfWords + 1);
	subSequence[0] = '\0';
	words = strtok (testPara, delims);
	while (words)
	{
		// Checking if word exists
		wordExists = checkWordIfExists (words, seqWords, numOfWords);
		if (wordExists)
		{
			numOfWordsFound++;
			subSequence = strcat (subSequence, words);
			subSequence = strcat (subSequence, " ");
			//printf ("%s\n", words);
		}
		else
		{
			numOfWordsFound = 0;
			subSequence[0] = '\0';
		}
		if (numOfWordsFound == numOfWords)
		{
			//printf ("%s\n", subSequence);
			break;
		}
		//printf ("%d: %s\n", __LINE__, words);
		words = strtok (NULL, delims);
	}
	// If subsequence exists, print the subsequence, else print "NO SUBSEGMENT FOUND"
	subSequenceLength = strlen (subSequence) - 2;
	subSequence[subSequenceLength] = '\0';
	if (numOfWordsFound == numOfWords )
		printf ("%s", subSequence);
		//printf ("Got here");
	else
		printf ("NO SUBSEGMENT FOUND");
}

int main ()
{
	int i, numOfWords;
	char testPara[200000], **subSeqChars;

	//printf ("Enter paragraph: ");
	gets (testPara);
	//printf ("%s\n", testPara);

	//printf ("Enter number of words and the words:\n");
	scanf ("%d", &numOfWords);

	subSeqChars = (char **) malloc (sizeof (char *) * numOfWords);
	for (i = 0; i < numOfWords; i++)
	{
		subSeqChars[i] = (char *) malloc (WORD_LENGTH);
		scanf ("%s", subSeqChars[i]);
	}
	/*
	printf ("Printing\n");
	for (i = 0; i < numOfWords; i ++)
	{
		printf ("%s\n", subSeqChars[i]);
	}
	*/
	findShortestSubsequence (testPara, numOfWords, subSeqChars);
	//printf ("\n");
	return 0;
}
