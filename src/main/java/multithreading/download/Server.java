package multithreading.download;

import java.util.Arrays;
import java.util.Iterator;

public class Server {
    private final Iterator<Integer> dataIterator;

    public Server() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        dataIterator = Arrays.stream(data).iterator();
    }

    public Integer download() {
        Integer num = getNext();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num;
    }

    synchronized private Integer getNext() {
        if (dataIterator.hasNext()) {
            return dataIterator.next();
        }
        return null;
    }
}
