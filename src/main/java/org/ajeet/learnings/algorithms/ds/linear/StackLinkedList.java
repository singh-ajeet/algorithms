package org.ajeet.learnings.algorithms.ds.linear;

public final class StackLinkedList<T> {
    private Node head;

    public void push(T element){
        Node node = new Node(element);
        node.next = head;
        head = node;
    }

    public T pop() {
        if (head == null){
            return null;
        } else {
            Node<T> tmp = head;
            head = head.next;
            //Cleanup
            tmp.next = null;
            return tmp.value;
        }
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (int i=0; i<5; i++){
            System.out.println(stack.pop());
        }
    }
}
