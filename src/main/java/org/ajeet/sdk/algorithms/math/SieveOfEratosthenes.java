package org.ajeet.sdk.algorithms.math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class SieveOfEratosthenes {

    public static List<Integer> primeNumbers(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public static void main(String[] args) {
        System.out.println(primeNumbers(10));
    }
}