package org.ajeet.learnings.algorithms.linear;

public class LinkedList<T> implements IList<T> {
    private Node<T> first = null;
    private Node<T> last = null;

    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        if(first == null){
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    @Override
    public void addFirst(T element) {
        Node newNode = new Node(element);
        newNode.next = first;
        first = newNode;
        if (first == null){
            first = last = newNode;
        }
    }

    @Override
    public void addLast(T element) {
        Node newNode = new Node(element);
        if (last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
        }
    }

    @Override
    public T remove(int index) {
        if(first == null){
            return null;
        }
        //Check if we are deleting first element;
        if(index == 0){
            Node<T> tmp = first;
            first = first.next;
            T value =  tmp.value;
            tmp.next = null;
            tmp = null;
            if(first == null){
                last = null;
            }
            return value;
        } else {
            Node<T> tmp = first;
            Node<T> previous = null;
            int i = 0;

            while(tmp != null){
                if (i++ == index){
                    if(last == tmp){
                        last = previous;
                    }
                    previous.next = tmp.next;
                    T value =  tmp.value;
                    tmp.next = null;
                    return value;
                }
                previous = tmp;
                tmp = tmp.next;
            }
            return null;
        }
    }

    @Override
    public T find(int index) {
        Node<T> tmp = first;
        int i=0;
        while (tmp != null){
            if (i++ == index){
                return tmp.value;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IList<Character> vivek = new LinkedList<>();
        vivek.add('V');
        vivek.add('I');
        vivek.add('V');
        vivek.add('E');
        vivek.add('K');

        for(int i=0; i<5; i++){
            System.out.println(vivek.find(i));
        }

        vivek.remove(1);
        vivek.remove(3);

        System.out.println("====================== After removal =====================");
        for(int i=0; i<5; i++){
            System.out.println(vivek.find(i));
        }

        vivek.addFirst('I');
        vivek.addLast('I');

        System.out.println("====================== After adding first and last =====================");
        for(int i=0; i<5; i++){
            System.out.println(vivek.find(i));
        }
    }
}
