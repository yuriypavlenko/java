package multithreading.download;

public class Client implements Runnable {
    Server server;

    public Client(Server server) {
        this.server = server;
    }

    public static void createThreadAndStart(Server server) {
        Thread thd = new Thread(new Client(server));
        thd.start();
    }

    @Override
    public void run() {
        while (true) {
            Integer part = server.download();
            if (part == null) {
                break;
            }
            System.out.println("Part: " + part);
        }
    }
}
