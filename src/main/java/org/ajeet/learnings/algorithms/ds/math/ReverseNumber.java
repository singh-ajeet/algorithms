package org.ajeet.learnings.algorithms.ds.math;

public final class ReverseNumber {

    public static int reverse(int number) {
        int ret = 0;
        while (number != 0) {
            // Handle overflow/underflow
            // Integer.MAX_VALUE (2147483647),
            if (Math.abs(ret) > 214748364) {
                return 0;
            }
            ret = ret * 10 + number % 10;
            number /= 10;
        }
        return ret;
    }

      public static void main(String[] args) {
        System.out.println(reverse(-1231212319));
    }
}
