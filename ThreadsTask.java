import java.util.ArrayList;
import java.util.List;

public class ThreadsTask {
    public static final Object lock = new Object();

    public static void mainFunc(Matrix matrix, int threadCount, int num) throws InterruptedException {
        int step = matrix.getDimension() / threadCount;
        int start, finish;
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            start = i * step;
            finish = start + step;
            if (i == threadCount - 1) {
                finish = matrix.getDimension();
            }
            Runnable runnable = Worker.getElementsAndMaxNumber(matrix, start, finish, num);
            Thread thread = new Thread(runnable);
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread1 : threadList) {
            thread1.join();
        }

    }
}