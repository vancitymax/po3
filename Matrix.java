import java.util.Random;

public class Matrix {

    private int dimension;
    private int [] matrix;
    private boolean finished;
    public Matrix(int dimension)
    {
        this.dimension=dimension;
        matrix=new int[dimension];
    }
    public int[] getMatrix() {
        return matrix;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    public boolean isFinished() {
        return finished;
    }

    public void setMatrix(int[] matrix) {
        this.matrix = matrix;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    public void fillMatrix()
    {
        Random random= new Random();
        for (int i = 0; i <dimension ; i++) {
            matrix[i]=random.nextInt(100)+1;
        }
    }
    public void findElementsAndMaxNumber(int number)
    {
        int max_number=Integer.MIN_VALUE;
        int counter=0;
        for(int i=0;i<dimension;i++)
        {
            if(matrix[i]>number)
            {
                counter++;
            }
        }
        System.out.println("Кількість елементів більших за довільне число = " + counter);
        for (int i = 0; i <dimension ; i++) {
            if(matrix[i]>max_number)
                max_number=matrix[i];
        }
        System.out.println("Найбільше число:" + max_number);
    }
    public void outMatrix()
    {
        System.out.print("[");
        for (int i = 0; i < dimension; i++) {
            System.out.print(matrix[i]+ " ");

        }
        System.out.println("]");
    }
}
