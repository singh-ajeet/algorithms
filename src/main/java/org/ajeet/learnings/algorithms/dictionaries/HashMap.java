package org.ajeet.learnings.algorithms.dictionaries;

public final class HashMap<K, V> implements Dictionary<K, V> {

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static final int rightShift(int number) {
        return number ^ (number >>> 16);
    }

    static long convertDecimalToBinary(int n)   {
        long binaryNumber = 0;
        int remainder, i = 1, step = 1;

        while (n!=0)  {
            remainder = n % 2;
            //System.out.printf("Step %d: %d/2, Remainder = %d, Quotient = %d\n", step++, n, remainder, n/2);
            n /= 2;
            binaryNumber += remainder * i;
            i *= 10;
        }
        return binaryNumber;
    }

    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(222));
        System.out.println(convertDecimalToBinary(222 >>> 4));
        System.out.println(convertDecimalToBinary(rightShift(222)));
    }
}
