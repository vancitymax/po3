import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static int counter=0;
    public static int max=0;
    public static AtomicInteger countByAtomic=new AtomicInteger(0);
    public static AtomicInteger maxByAtomic = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Matrix matrix = new Matrix(20000);
        matrix.fillMatrix();

        long startTime = System.nanoTime();
        ThreadsTask.mainFunc(matrix, 16, 10);
        long finishTime = System.nanoTime();

        System.out.println("Max number: " + max);
        System.out.println("Count: " + counter);
        System.out.println("Operation time: " + ((finishTime - startTime) / 100_00_00) + "ms");
//        System.out.println(countByAtomic);
//        System.out.println(maxByAtomic);
    }
}