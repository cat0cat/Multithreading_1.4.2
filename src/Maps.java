import java.util.Map;
import java.util.Random;

public class Maps {

    private static final int MAX = 5000;
    private static final int SIZE = 100;
    public static Map<Integer,Integer> map;

    public void write(){
        long start = System.nanoTime();
        int[] arr = randomArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(i,arr[i]);
        }
        long finish = System.nanoTime();
        System.out.printf("Время записи в %s составляет %d нс.\n",
                 Thread.currentThread().getName(), (finish - start));
    }
    public void read(){
        long start = System.nanoTime();
        int[] arr = randomArray();
        for (int i = 0; i < arr.length; i++) {
            map.get(i);
        }
        long finish = System.nanoTime();
        System.out.printf("Время чтения в %s составляет %d нс.\n",
                Thread.currentThread().getName(), (finish - start));
    }

    private int[] randomArray(){
        Random random = new Random();
        int[] arr = new int [SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(MAX);
        }
        return arr;
    }

}
