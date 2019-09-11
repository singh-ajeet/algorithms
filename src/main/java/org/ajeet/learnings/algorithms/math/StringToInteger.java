package org.ajeet.learnings.algorithms.math;

public final class StringToInteger {

    public static int convert(String input) {
        if(input == null || input.length() == 0)
            return 0;

        int result = 0;
        boolean signFound = false;
        boolean isNegative = false;
        int i = 0;
        while(i < input.length()) {
            // Ignore initial whitespaces
            while (input.charAt(i) == ' ') i++;
            // + or - should be first character after any spaces
            if(input.charAt(i) =='-' && !signFound) {
                isNegative = true;
                signFound = true;
            }
            else if (input.charAt(i) =='+' && !signFound) {
                signFound = true;
            }
            else if(!Character.isDigit(input.charAt(i)))
                return 0;
            else {
//                int newDigit = Character.getNumericValue(input.charAt(i));
                int newDigit = toInt(input.charAt(i));
                if(result == 0)
                    result = newDigit;
                else {
                    // Handling overflow
                    if(!isNegative && Integer.MAX_VALUE - result >= newDigit)
                        return Integer.MAX_VALUE;
                    else if(isNegative && Integer.MIN_VALUE + result <= -1 * newDigit)
                        return Integer.MIN_VALUE;
                    result = result * 10 + newDigit;
                }
            }
            i++;
        }
        if(isNegative)
            result = result * -1;
        return result;
    }

    private static int toInt(char ch){
        return ch - '0';
    }

    public static void main(String[] args) {
      //  System.out.println(convert(" +2147483648"));
        System.out.println(convert(" -2147483648455"));
      //  System.out.println(convert(" -123"));
    }
}
