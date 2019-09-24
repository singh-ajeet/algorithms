package org.ajeet.learnings.algorithms.ds.tree;

import java.util.PriorityQueue;
import java.util.Scanner;

public final class FilesPriorityQueue {
    private final PriorityQueue<Tuple> files = new PriorityQueue<>();

    public boolean offer(Scanner e) {
        if(e.hasNext()){
            files.add(new Tuple(e.nextLine(), e));
            return true;
        }
        return false;
    }

    public String poll(){
        Tuple tuple = files.poll();
        String value = tuple.key;
        if(tuple.hasNext())
            files.offer(tuple.next());
        return value;
    }

 /*   private static final class FilesComparator implements  Comparator<Scanner> {
        @Override
        public int compare(Scanner first, Scanner second) {
            String firstLine = "";
            if(first.hasNext()){
                firstLine = first.nextLine();
            }
            String secondLine = "";
            if(second.hasNext()){
                secondLine = second.nextLine();
            }
            return firstLine.compareTo(secondLine);
        }
    }*/

    private static class Tuple implements Comparable<Tuple>{
        public final String key;
        public final Scanner scanner;
        public Tuple next;

        public Tuple(String key, Scanner scanner) {
            this.key = key;
            this.scanner = scanner;
        }

        public boolean hasNext(){
            if(scanner.hasNext()) {
                next= new Tuple(scanner.nextLine(), scanner);
                return true;
            }
            return false;
        }
        public Tuple next(){
             return next;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.key.compareTo(that.key);
        }
    }

    public static void main(String[] args) {
        FilesPriorityQueue queue = new FilesPriorityQueue();
        queue.offer(new Scanner("File path"));
    }
}
