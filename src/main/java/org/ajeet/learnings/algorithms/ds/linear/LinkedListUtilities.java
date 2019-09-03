package org.ajeet.learnings.algorithms.ds.linear;

public final class LinkedListUtilities {

    private LinkedListUtilities() {
        throw new IllegalStateException("LinkedListUtilities is not instable.");
    }

    public static Node reverse(Node start){
        if(start == null || start.next == null){
            return start;
        }

        Node current = start;
        Node newStart = null;

        while(current != null){
            Node tmp = current.next;
            current.next = newStart;
            newStart = current;
            current = tmp;
        }

        return newStart;
    }

    public static Node getMergeNode(Node firstList, Node secondList){
        if(firstList == null || secondList == null){
            throw new IllegalArgumentException("firstList & secondList both should be no null.");
        }
        int firstSize = getSize(firstList);
        int secondSize = getSize(secondList);
        if(firstSize > secondSize){
            return getMergeNode(firstSize - secondSize, firstList, secondList);
        } else {
            return getMergeNode(secondSize - firstSize, secondList, firstList);
        }
    }

    private static Node getMergeNode(int move, Node firstList, Node secondList) {
        while( move-- > 0){
            firstList = firstList.next;
        }
        while(firstList != null && secondList != null){
            firstList = firstList.next;
            secondList = secondList.next;
            if (firstList == secondList){
                return firstList;
            }
        }
        return null;
    }

    public static int getSize(Node firstList) {
        int count =  0;
        Node tmp = firstList;
        while (tmp != null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node<Character> V = new Node<>('V');
        Node<Character> I = new Node<>('I');

        Node<Character> G = new Node<>('G');
        G.next = I;

        System.out.println(getMergeNode(V, G));

        Node<Character> A = new Node<>('A');
        Node<Character> B = new Node<>('B');
        A.next  = B;
        Node<Character> C = new Node<>('C');
        B.next  = C;

        System.out.println(reverse(A));
    }
 }
