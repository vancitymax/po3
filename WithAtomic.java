public class WithAtomic implements Runnable {
    private int start;
    private int end;
    private Matrix matrix;
    private int number;

    public WithAtomic(Matrix matrix, int start, int end, int number) {
        this.matrix = matrix;
        this.start = start;
        this.end = end;
        this.number = number;
    }

    @Override
    public void run() {
        int count = 0;
        int max_num = 0;
        for (int i = start; i < end; i++) {
            int element = matrix.getMatrix()[i];
            if (element > number) {
                count++;
            }
            if (element > max_num) {
                max_num = element;
            }
        }
        Main.countByAtomic.addAndGet(count);
        Main.maxByAtomic.set(max_num);



    }
}