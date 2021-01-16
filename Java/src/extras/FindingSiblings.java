package extras;

public class FindingSiblings {
    int[] getSiblings(int[] inputArray, int fugitive) {
        int[] siblings = {-1};
        int startPos = 1;
        int endPos = 1;
        boolean fugitiveFound = false;

        if (inputArray.length > 1 && inputArray[0] != fugitive) {
            while (!fugitiveFound && startPos < inputArray.length - 1) {
                endPos = Math.min(startPos * 2, inputArray.length - 1);
                fugitiveFound = isFugitiveHere(inputArray, startPos, endPos, fugitive);
                if (!fugitiveFound)
                    startPos = endPos + 1;
            }
        }
        if (fugitiveFound) {
            siblings = fetchSubArrayWithoutTheFugitive(inputArray, startPos, endPos, fugitive);
        }

        return siblings;
    }

    private boolean isFugitiveHere(int[] inputArray, int startPos, int endPos, int fugitive) {
        boolean fugitiveFound = false;
        for(int i = startPos; i <= endPos; i++) {
            if (fugitive == inputArray[i]) {
                fugitiveFound = true;
                break;
            }
        }
        return fugitiveFound;
    }

    private int[] fetchSubArrayWithoutTheFugitive(int[] inputArray, int startPos, int endPos, int fugitive) {
        int[] subArray = new int[endPos - startPos];
        int counter = 0;
        for (int i = startPos; i <= endPos; i++) {
            if (inputArray[i] != fugitive)
                subArray[counter++] = inputArray[i];
        }
        return subArray;
    }
}
