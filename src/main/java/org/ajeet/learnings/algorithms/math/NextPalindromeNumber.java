package org.ajeet.learnings.algorithms.math;

import java.math.BigInteger;

public final class NextPalindromeNumber {

    public static String nextPalindrome(String num) {
        int len = num.length();
        String left = num.substring(0, len / 2);
        String middle = num.substring(len / 2, len - len / 2);
        String right = num.substring(len - len / 2);

        if (right.compareTo(reverse(left)) < 0)
            return left + middle + reverse(left);

        String next = new BigInteger(left + middle).add(BigInteger.ONE).toString();
        return next.substring(0, left.length() + middle.length())
                + reverse(next).substring(middle.length());
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int[] find(int[] number) {
        return null;
    }

    public static int find(int number) {
        if (number < 9)
            return number + 1;
        if(number == 9)
            return 11;

        int div = 1;
        while (number/div >= 10)
            div *= 10;

        int palindrome = 0;
        int startMultiplier = div;
        int endMultiplier = 1;
        boolean decreased = false;

        while (number != 0) {
            int firstDigit = number / div;
            //in case of odd number of digits, if we are at center than we are done
            if(number < 10) {
                if(decreased)
                    firstDigit++;
                palindrome = firstDigit * startMultiplier + palindrome;
                return palindrome;
            } else {
                palindrome = firstDigit * startMultiplier + palindrome;
            }


            int lastDigit = number % 10;

            if( lastDigit != firstDigit) {
                if(lastDigit > firstDigit)
                    decreased = true;
                lastDigit = firstDigit;
            }
            palindrome = lastDigit * endMultiplier + palindrome;

          //  System.out.println("First: " + firstDigit + ", Last: " + lastDigit);
            number = number % div; // Reduce by 1 digit from start
            number = number / 10; // Reduce by 1 digit from end

            div = div/100; // We already reduced two digits so div need to be adjust accordingly.
            startMultiplier = startMultiplier / 10;
            endMultiplier = endMultiplier * 10;
        }

        return palindrome;
    }

    public static void main(String[] args) {
/*
        System.out.println(find(123));
        System.out.println(find(12321));
        System.out.println(find(12345));

        System.out.println(nextPalindrome("4"));
        System.out.println(nextPalindrome("9"));
        System.out.println(nextPalindrome("15"));
*/
        System.out.println(nextPalindrome("99"));
/*
        System.out.println(nextPalindrome("149"));
        System.out.println(nextPalindrome("123450000"));
        System.out.println(nextPalindrome("123454322"));
*/
    }
}
