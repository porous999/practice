package palindromeIndex;

import java.util.Iterator;
import java.util.List;

public class PalindromeIndex {

	private static List<String> caseList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String caseString;
		caseList = null;
		caseList.add("quyjjdcgsvvsgcdjjyq");
		caseList.add("hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh");
		caseList.add("fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf");
		caseList.add("lhrxvssvxrhl");
		caseList.add("bsyhvwfuesumsehmytqioswvpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb");
		caseList.add("fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf");
		caseList.add("mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm");
		caseList.add("tpqknkmbgasitnwqrqasvolmevkasccsakvemlosaqrqwntisagbmknkqpt");
		caseList.add("prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp");
		
		Iterator<String> myIterator = caseList.iterator();
		while (myIterator.hasNext()) {
			caseString = myIterator.next();
			System.out.println (caseString);
			//System.out.print(palindromeIndex(caseString, caseString.length()));
			//System.out.println(":" + numberOfCases[i]);
		}
	}
	
	private static boolean checkIfPalindrome(String caseString, int caseStringLength) {
		// TODO Auto-generated method stub
		
		int i;
		
		for (i = 0; i < caseStringLength; i++){
			if (caseString.charAt(i) != caseString.charAt(caseStringLength - i - 1)) {
				System.out.println(caseString + " is not palindrome!!");
				return false;
			}
		}
		System.out.println(caseString + " is a palindrome");
		return true;
	}

	public static int palindromeIndex(String caseString, int caseStringLength) {
		int index = -1;
		int i, j;
		
		if (checkIfPalindrome(caseString, caseStringLength)) {
			return index;
		}
		String tempCaseString = null;
		
		for (i = 0 ; i < caseStringLength; i++) {
			// Take part of string without this index and check for palindromancy
			index = i;
			if (checkIfPalindrome(tempCaseString, tempCaseString.length()))
				break;
			tempCaseString = null;
		}
		
		return index;
	}
}
