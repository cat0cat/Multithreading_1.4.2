import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Maps maps = new Maps();
        Maps.map = new ConcurrentHashMap<>();
        new Thread(null, maps::write, "ConcurrentHashMap").start();
        new Thread(null, maps::read, "ConcurrentHashMap").start();

        Maps.map = Collections.synchronizedMap(new HashMap<>());
        new Thread(null, maps::write, "SynchronizedMap").start();
        new Thread(null, maps::read, "SynchronizedMap").start();

//        Время записи map в ConcurrentHashMap больше, чем в SynchronizedMap.
//        Время чтения map в ConcurrentHashMap больше, чем в SynchronizedMap.
//        При увеличении размера списка тенденция сохраняется.
    }
}