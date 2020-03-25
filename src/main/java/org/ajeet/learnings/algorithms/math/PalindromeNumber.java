package org.ajeet.learnings.algorithms.math;

public final class PalindromeNumber {

    public static int check(int number) {
        int div = 1;
        while (number/div >= 10)
            div = div * 10;

        while(number != 0) {
            int first = number/div;
            System.out.println(first);
            number = number % div; // Remove first digit
            number = number/10;  // Remove last digit
            div = div/100; // We reduced two digits so div need to shorten by two digits
        }

        return div;
    }

    public static void main(String[] args) {
        System.out.println(check(12321));
    }
}
