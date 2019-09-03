package org.ajeet.learnings.java;

import java.util.function.Supplier;

public final class LazyEvaluation {
    private static final Supplier<String> STRING_SUPPLIER = () -> Lazy.STRING;

    static {
        System.out.println("LazyEvaluation initialized");
    }

    private static final class Lazy {
        private final static String STRING = get();

        static {
            System.out.println("Lazy initialized");
        }

        private static String get() {
            System.out.println("ZZZZZZZZZzzzzzzzzz Evaluating Lazyly  zzzzzzzzzzzZZZZZZZZZZZ");
            return "I am lazy";
        }
    }

    public static void main(String[] args) {
        System.out.println("=============");
        System.out.println(STRING_SUPPLIER.get());
    }
}
