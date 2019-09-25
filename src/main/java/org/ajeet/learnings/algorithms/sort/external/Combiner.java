package org.ajeet.learnings.algorithms.sort.external;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class Combiner {
    private final PriorityQueue<FileHandle> files = new PriorityQueue<>();

    public boolean isEmpty(){
        return files.isEmpty();
    }

    public boolean offer(File file) {
        try {
            files.add(FileHandle.open(file));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String poll(){
        FileHandle tuple = files.poll();
        String value = tuple.getData();
        if(tuple.hasData())
            files.offer(tuple);
        return value;
    }

    private static class FileHandle implements Comparable<FileHandle>{
        private String data;
        private final Scanner scanner;

        private FileHandle(Scanner scanner) {
            this.scanner = scanner;
        }

        public boolean hasData(){
            if(scanner.hasNext()) {
                data = scanner.nextLine();
                return true;
            } else {
                scanner.close();
                return false;
            }
        }

        public String getData(){
            return data;
        }

        @Override
        public int compareTo(FileHandle that) {
            if(this.data == that.data)
                return 0;
            if (this.data == null)
                return -1; // we are considering null as less
            if(that.data == null)
                return 1;
            return this.data.compareTo(that.data);
        }

        public static FileHandle open(File file) throws IOException {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            return new FileHandle(new Scanner(bufferedInputStream));
        }
    }

    public static void main(String[] args) {
        Combiner queue = new Combiner();
        queue.offer(new File("G:\\TestData\\sortIt\\Part1.txt"));
        queue.offer(new File("G:\\TestData\\sortIt\\Part2.txt"));

        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
