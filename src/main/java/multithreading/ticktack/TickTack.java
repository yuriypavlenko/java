package multithreading.ticktack;

public class TickTack {
    boolean ticked = false;

    synchronized public void tick() {
        if (ticked) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("Тик ");
        ticked = true;
        notify();
    }

    synchronized public void tack() {
        if (!ticked) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Так");
        ticked = false;
        notify();
    }
}
