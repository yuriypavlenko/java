package multithreading.ticktack;

public class Program {
    public static void main(String[] args) {
        TickTack tickTack = new TickTack();
        Thread tickThread = TickJob.createThreadAndStart(tickTack, "Тик");
        Thread tackThread = TackJob.createThreadAndStart(tickTack, "Так");

        try {
            tickThread.join();
            tackThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
