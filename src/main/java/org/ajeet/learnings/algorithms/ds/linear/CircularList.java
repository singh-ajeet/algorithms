package org.ajeet.learnings.algorithms.ds.linear;

public final class CircularList<T>  {
    private Node<T> head = null;
    private Node<T> last = null;

    public void add(T element) {
        Node<T> node = new Node<>(element);
        if (head == null){
            head = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        last.next = head;
    }

    public T remove(int index) {
        if (head == null){
            throw new RuntimeException("List is empty");
        }
        int count = 0;

        Node<T> tmp = head;
        while(tmp != null){
            if (count++ == index){
                //Removing element by replacing it.
                //We need to adjust head and last pointers
                if(head == tmp.next){
                    head = tmp;
                }
                if (last == tmp.next){
                    last = tmp;
                }
                Node<T> removed = tmp.next;

                tmp.value = tmp.next.value;
                tmp.next = tmp.next.next;

                return removed.value;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public T find(int index) {
        int count = 0;
        Node<T> tmp = head;
        while(tmp != null){
            if (count++ == index){
                return tmp.value;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        CircularList<Integer> circular = new CircularList<>();
        circular.add(1);
        circular.add(2);
        circular.add(3);
        circular.add(4);

        circular.remove(1);

        //It should print same list 3 times
        for(int i=0; i< 12; i++){
            System.out.println(circular.find(i % 4));
        }

        //Manually accessing elements
        Node<Integer> tmp = circular.head;
        //It should print same list 3 times
        for(int i=0; i< 20; i++){
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
}
