# include <stdio.h>
# include <stdlib.h>
# include <string.h>
# include <strings.h>

# define WORD_LENGTH 15
# define PARA_LENGTH 200000

int checkWordIfExists (char *word, char **seqWords, int numOfWords)
{
	int flag = -1, i;
	for (i = 0; i < numOfWords; i++)
	{
		if (strcasecmp (word, *(seqWords + i)) == 0)
		{
			flag = i;
			break;
		}
	}
	return flag;
}

void printSubsequence (char **subSequence, int numOfWords)
{
	int i;
	for (i = 0; i < numOfWords - 1; i++)
		printf ("%s ", *(subSequence + i));
	printf ("%s", *(subSequence + i));
}

void findShortestSubsequence (char *testPara, int numOfWords, char **seqWords)
{
	int i, wordExists, numOfWordsFound = 0, subSequenceLength;
	int index = 0, wordsFound[numOfWords];
	char *words, **subSequence;
	char delims[10] = " .,";

	for (i = 0; i < numOfWords; i++)
		wordsFound[i] = 0;

	subSequence = (char **) malloc (sizeof (char *) * numOfWords);
	//subSequence[0] = '\0';
	for (i = 0; i < numOfWords; i++)
	{
		*(subSequence + i) = (char *) malloc (WORD_LENGTH);
		*(*(subSequence + i)) = '\0';
	}
	words = strtok (testPara, delims);
	while (words)
	{
		// Checking if word exists
		wordExists = checkWordIfExists (words, seqWords, numOfWords);
		if (wordExists >= 0)
		{
			index = wordExists;
			if (wordsFound[index] == 0)
			{
				numOfWordsFound++;
				strcpy (*(subSequence + index), words);
				wordsFound[index] = 1;
				index++;
				printf ("%s\n", words);
			}
			else
			{
				index = 0;
				for (i = 0; i < numOfWords; i++)
			                wordsFound[i] = 0;
				for (i = 0; i < numOfWords; i++)
			                *(*(subSequence + i)) = '\0';
				numOfWordsFound = 0;
				printf ("++++++++++++++++++++++++++++\n");
			}
		}
		else
		{
			numOfWordsFound = 0;
			subSequence[0] = '\0';
			printf ("++++++++++++++++++++++++++++\n");
		}
		if (numOfWordsFound == numOfWords)
			break;
		words = strtok (NULL, delims);
	}
	// If subsequence exists, print the subsequence, else print "NO SUBSEGMENT FOUND"
	if (numOfWordsFound == numOfWords )
		printSubsequence (subSequence, numOfWords);
	else
		printf ("NO SUBSEGMENT FOUND");
}

void main ()
{
	int i, numOfWords;
	char testPara[PARA_LENGTH], **subSeqChars;

	gets (testPara);
	scanf ("%d", &numOfWords);

	subSeqChars = (char **) malloc (sizeof (char *) * numOfWords);
	for (i = 0; i < numOfWords; i++)
	{
		subSeqChars[i] = (char *) malloc (WORD_LENGTH);
		scanf ("%s", subSeqChars[i]);
	}
	findShortestSubsequence (testPara, numOfWords, subSeqChars);
	//return 0;
}
