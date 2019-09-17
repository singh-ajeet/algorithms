package org.ajeet.learnings.algorithms.math;

import java.math.BigInteger;
import java.util.*;

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

    public static List<Integer> nextPalindrome(int[] number) {
        //Corner case 1
        if(number == null || number.length == 0)
            return Collections.emptyList();

        //Corner case 2
        if (number.length == 1) {
            if(number[0] == 9)
                return Collections.singletonList(11);
            else
                return Collections.singletonList(number[0] + 1);
        }
        int n = number.length;
        int mid = -1;
        int left;
        int right;
        //For even size there will be no mid number
        if(n % 2 == 0) {
            left = n / 2 - 1;
            right = n / 2;
        } else {
            mid = n / 2;
            left = mid - 1;
            right = mid +1;
         }

        LinkedList<Integer> result = new LinkedList();
        //Left half
        for(int i=0; i<=left; i++)
            result.add(number[i]);

        //check if right is larger than reverse of left
        boolean rightSmaller = false;
        for(int i = right, j = left; i<number.length && j >=0; i++, j--) {
            if (number[i] < number[j]) {
                rightSmaller = true;
                break;
            }
        }

        if(mid != -1) {
            result.add(number[mid]);
        }

        if(!rightSmaller) {
            int start = mid == -1 ? left:mid;
            increaseBy1(result, start);
        }

        for (int i = left; i>=0; i--)
            result.add(result.get(i));

        return result;
     }

    private static void increaseBy1(LinkedList<Integer> result, int mid) {
        for(int i = mid; i>=0; i--) {
            int num = result.get(i) + 1;
            if(num < 10){
                result.set(i, num);
                return;
            }
            result.set(i, 0);
        }
        result.addFirst(1);
    }

    private static void reverse(int[] input){
        for(int i=0, j=input.length -1; i<j; i++, j-- ) {
            int tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
        }
    }

    private static void reverseCopy(int[] src, int srcStart, int[] destination, int destStart) {
        for(int i = src.length - 1; i >=0; i--){
            destination[destStart++] = src[i];
        }
    }

    public static int nextPalindrome(int number) {
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
        System.out.println(nextPalindrome(123));
        System.out.println(nextPalindrome(12321));
        System.out.println(nextPalindrome(12345));

        System.out.println(nextPalindrome("4"));
        System.out.println(nextPalindrome("9"));
        System.out.println(nextPalindrome("15"));

        System.out.println(nextPalindrome("99"));

        System.out.println(nextPalindrome("149"));
        System.out.println(nextPalindrome("123450000"));
        System.out.println(nextPalindrome("123454322"));

        int[] input = {1, 2, 3};
        System.out.println(nextPalindrome(input));
        int[] input2 = {9, 9};
        System.out.println(nextPalindrome(input2));
        int[] input3 = {9};
        System.out.println(nextPalindrome(input3));
        int[] input4 = {8};
        System.out.println(nextPalindrome(input4));
    }
}
