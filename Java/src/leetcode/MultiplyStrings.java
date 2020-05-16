package leetcode;

/**
 * Created by tanmays on 10/5/20.
 * Prob statement: https://leetcode.com/problems/multiply-strings/
 *
 * Do not directly convert Strings to int.
 */
class MultiplyStrings {

    static String multiply(String num1, String num2) {
        return recursiveSolution(num1, num2);
    }

    private static String recursiveSolution(String num1, String num2) {
        if (num1.isEmpty() && num2.isEmpty())
            return "";
        else if (num1.isEmpty() || num2.isEmpty())
            return num1.isEmpty()? num2: num1;
        else if (num1.equals("0") || num2.equals("0"))
            return "0";
        else
            return multiplyRecursively(num1, num2,"", 0);
    }

    private static String multiplyRecursively(String num1, String num2, String result, int shift) {

        if (shift >= num2.length())
            return result;
        else {
            int num2Int = Integer.parseInt(String.valueOf(num2.charAt(num2.length() - shift - 1)));
            String prodStr = getSimpleProduct(num1, num2Int, 0);
            if (result.isEmpty())
                result = prodStr;
            else {
                for (int i = 0; i < shift; i++)
                    prodStr = prodStr.concat("0");
                result = getSimpleSum(result, prodStr, 0);
            }
            return multiplyRecursively(num1, num2, result, shift + 1);
        }
    }

    static String getSimpleSum(String num1Str, String num2Str, int carry) {

        if (num2Str.isEmpty() && num1Str.isEmpty())
            return "";
        else {

            int num2StrLen = num2Str.length();
            int num1StrLen = num1Str.length();
            int num2CharNum = num2StrLen == 0? 0: Integer.parseInt(String.valueOf(num2Str.charAt(num2StrLen - 1)));
            int num1CharNum = num1StrLen == 0? 0: Integer.parseInt(String.valueOf(num1Str.charAt(num1StrLen - 1)));

            int sum = carry + num2CharNum + num1CharNum;
            carry = sum / 10;

            num1Str = num1StrLen > 0? num1Str.substring(0, num1StrLen - 1): "";
            num2Str = num2StrLen > 0? num2Str.substring(0, num2StrLen - 1): "";

            return getSimpleSum(num1Str, num2Str, carry).concat(String.valueOf(sum % 10));
        }
    }

    static String getSimpleProduct(String num1Str, int num2, int carry) {

        if (num2 == 0)
            return "0";
        if (num1Str.isEmpty())
            return carry == 0? "": String.valueOf(carry);
        else if (num1Str.equals("0"))
            return "0";
        else {

            int num1StrLen = num1Str.length();

            int sum = carry + Integer.parseInt(String.valueOf(num1Str.charAt(num1StrLen - 1))) * num2;
            carry = sum / 10;

            return getSimpleProduct(num1Str.substring(0, num1StrLen - 1), num2, carry).concat(String.valueOf(sum % 10));
        }
    }
}
