public class Worker {
    public static Runnable getElementsAndMaxNumber(Matrix matrix, int start, int end,int num){
        return new WithoutAtomic(matrix, start, end,num);
    }
    public static Runnable getElAndNumWithAtomic(Matrix matrix, int start, int end,int num)
    {
        return new WithAtomic(matrix, start, end,num);
    }
}
