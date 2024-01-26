package multithreading.ticktack;

public class TackJob extends Job {

    private TackJob() {}

    public static Thread createThreadAndStart(TickTack tickTack, String name) {
        TackJob job = new TackJob();
        job.tickTack = tickTack;
        job.thd = new Thread(job, name);
        job.thd.start();
        return job.thd;
    }

    @Override
    public void run() {
        for (int i = 1; i <= tries; i++) {
            tickTack.tack();
        }
    }
}
