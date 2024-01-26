package multithreading.download;
public class Program {
    public static void main(String[] args) {
        Server server = new Server();

        for (int i = 1; i <= 3; i++) {
            Client.createThreadAndStart(server);
        }
    }
}
