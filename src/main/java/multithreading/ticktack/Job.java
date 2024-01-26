package multithreading.ticktack;

public abstract class Job implements Runnable {
    TickTack tickTack;
    int tries = 5;
    Thread thd;
}
