package org.ajeet.learnings.algorithms.math;

public final class IsPrime {

    public static boolean test(int number) {
        if((number > 2 && number % 2 == 0) || number == 1) {
            return false;
        }
        //Verify all odd numbers, because 2 is the only number that is prime so we can skip all even number
        for (int i = 3; i <= (int)Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        //Number is prime
        return true;
    }

    public static void main(String[] args) {
        System.out.println(test(10));
    }
}
