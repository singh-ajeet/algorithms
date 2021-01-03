package org.ajeet.learnings.algorithms.list;

public final class LinkedList<T> {
    private ListNode first;
    private ListNode last;
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

    private ListNode<T> find(int index) {
        ListNode<T> tmp = first;
        int currentIndex = 0;
        while (tmp != null && currentIndex++ != index)
            tmp = tmp.next;
        return tmp;
    }

    private void addBefore(T value, ListNode<T> node) {
        T oldValue = node.value;

        ListNode<T> newNode = new ListNode<>(oldValue);
        newNode.next = node.next;

        node.value = value;
        node.next = newNode;
    }

    public boolean addFirst(T value){
        ListNode<T> node = new ListNode<>(value);
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
        ListNode<T> node = new ListNode<>(value);
        if(last == null){
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
        return true;
    }

    public ListNode<T> reverse(){
        if(first == null)
            return null;

        ListNode futureFirst = new ListNode(first.value);
        ListNode current = first.next;

        while(current != null){
            ListNode tmp = new ListNode(current.value);
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
        ListNode tmp = first;
        while (tmp != null){
            stringBuilder.append(tmp.value);
            tmp = tmp.next;
            if(tmp != null)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();

        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');

        ListNode revered = list.reverse();
        while (revered != null){
            System.out.println(revered.value);
            revered = revered.next;
        }

        list.add(2, 'X');

        System.out.println(list);
    }
}
