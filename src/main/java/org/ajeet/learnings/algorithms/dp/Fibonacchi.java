package org.ajeet.learnings.algorithms.dp;

public final class Fibonacchi {

    private Fibonacchi(){
        throw new RuntimeException(Fibonacchi.class.getName() + " cant be instantiated.");
    }

    public static int get(int N) {
        int first = 1;
        int second = 1;
        int current = 1;

        if(N <= 1)
            return current;

        for(int i = 2; i<= N; i++ ) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(get(4));
    }
}
