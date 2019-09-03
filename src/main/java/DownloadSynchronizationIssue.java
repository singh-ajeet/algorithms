import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class DownloadSynchronizationIssue {
    private static class Task implements Runnable {
        private  final CyclicBarrier barrier;

        private Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                barrier.await();
                Files.createDirectory(Paths.get("D:\\Testing\\downloadLocation\\"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier =  new CyclicBarrier(4);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));

        barrier.await();
    }
}
