package org.ajeet.learnings.algorithms.text;

public final class Palindrome {

    /**
     * Ignore whitepace, numbers and match should be case insensitive
     *
     * @param input
     * @return
     */
    public static boolean test(String input){
        if(input == null || input.length() == 0)
            throw new IllegalArgumentException("input string cant be null or empty.");

        int i = 0;
        int j = input.length()-1;

        while (i < j){
            while (i < j && !Character.isAlphabetic(input.charAt(i))) i++;
            while (i < j && !Character.isAlphabetic(input.charAt(j))) j--;

            if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(test("A man, a plan, a canal: Panama"));
        System.out.println(test("Palindrome"));
    }
}
