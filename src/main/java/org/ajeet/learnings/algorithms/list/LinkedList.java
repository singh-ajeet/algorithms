package org.ajeet.learnings.algorithms.list;

public final class LinkedList<T> {
    private Node first;
    private Node last;
    private int size;

    public boolean add(T value){
        //By default it will add at last index
        return addLast(value);
    }

    public void add(int index, T value){
        if(index <0 || index > size)
            throw new IllegalArgumentException("Index should be a positive number and less than size of list");

        if(index == 0)
            addFirst(value);
        else if (index == size)
            addLast(value);
        else
            addBefore(value, find(index));
    }

    private Node<T> find(int index) {
        Node<T> tmp = first;
        int currentIndex = 0;
        while (tmp != null && currentIndex++ != index)
            tmp = tmp.next;
        return tmp;
    }

    private void addBefore(T value, Node<T> node) {
        T oldValue = node.value;

        Node<T> newNode = new Node<>(oldValue);
        newNode.next = node.next;

        node.value = value;
        node.next = newNode;
    }

    public boolean addFirst(T value){
        Node<T> node = new Node<>(value);
        if(first == null){
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
        return true;
    }

    public boolean addLast(T value){
        Node<T> node = new Node<>(value);
        if(last == null){
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
        return true;
    }

    public Node<T> reverse(){
        if(first == null)
            return null;

        Node futureFirst = new Node(first.value);
        Node current = first.next;

        while(current != null){
            Node tmp = new Node(current.value);
            tmp.next = futureFirst;
            futureFirst = tmp;
            current = current.next;
        }
        return futureFirst;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedList[");
        Node tmp = first;
        while (tmp != null){
            stringBuilder.append(tmp.value);
            tmp = tmp.next;
            if(tmp != null)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node [" + value + "]";
        }
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();

        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');

        Node revered = list.reverse();
        while (revered != null){
            System.out.println(revered.value);
            revered = revered.next;
        }

        list.add(2, 'X');

        System.out.println(list);
    }
}
