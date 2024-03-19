public class WithoutAtomic implements Runnable {
    private int start;
    private int end;
    private Matrix matrix;
    private int number;

    public WithoutAtomic(Matrix matrix, int start, int end, int number) {
        this.matrix = matrix;
        this.start = start;
        this.end = end;
        this.number = number;
    }

    @Override
    public void run() {
        int count = 0;
        int max_num = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            int element = matrix.getMatrix()[i];
            if (element > number) {
                count++;
            }
            if (element > max_num) {
                max_num = element;
            }
        }
        long startTime = System.currentTimeMillis();
        synchronized (ThreadsTask.lock)
        {
            Main.max = max_num;
            Main.counter += count;
        }
        long finishTime = System.currentTimeMillis();
        long blockTime = finishTime - startTime;
        System.out.println("Block time: " + blockTime + "ms");



    }
}