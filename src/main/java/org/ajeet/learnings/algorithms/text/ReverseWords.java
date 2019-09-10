package org.ajeet.learnings.algorithms.text;

public final class ReverseWords {

    public static void reverseWords(char[] s) {
        reverse2(s, 0, s.length);
        int i = 0;
        for (int j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse2(s, i, j);
                i = j + 1;
            }
        }
    }
    private static void reverse2(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }
    }

    public static void reverseInPlace(char[] input){
        if (input == null || input.length == 0)
            throw new IllegalArgumentException("input string cant be null or empty.");

        reverse(input, 0, input.length-1);

        for(int i=0, j=0; i <= input.length; i++){
            if(i == input.length || input[i] == ' ') {
                reverse(input, j, i);
                j = i;
            }
        }
    }

    private static void reverse(char[] input, int from, int to) {
        int i = from;
        int j = to < input.length ? to:to-1;
        while (i < j) {
            char tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
            i++;
            j--;
        }
    }

    public static String reverse(String input){
        if (input == null || input.length() == 0)
            throw new IllegalArgumentException("input string cant be null or empty.");

        StringBuilder builder = new StringBuilder();
        int i = input.length() -1;

        while (i > 0){
            // Ignore spaces
            while (i>=0 && input.charAt(i) == ' ') i--;

            int j=i;
            while (j>=0 && input.charAt(j) != ' ') {
                j--;
            }
            builder.append(input.substring(j+1, i+1));
            builder.append(' ');
            i = j;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("the sky is blue "));
        char[] input = "the sky is blue ".toCharArray();
     //   reverseWords(input);
        reverseInPlace(input);
        System.out.println(new String(input));
    }
}
