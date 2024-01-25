package multithreading;

public class Example1Ver1 {

    static class S implements Runnable {
        private boolean state = false;
        private boolean stop = false;

        public void run() {
            while (!stop) {
                boolean newState = !state;
                setState(newState);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("S stopped!");
        }

        public void stop() {
            stop = true;
        }

        synchronized public void setState(boolean newState) {
            state = newState;
            System.out.println("S переключил состояние в " + newState);
            if (newState) {
                notifyAll();
            }
        }

        synchronized public boolean getState() {
            if (!state) {
                try {
                    System.out.println("W ждет");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return state;
        }
    }

    static class W implements Runnable {
        S s;
        int start = 30;

        W(S s) {
            this.s = s;
        }

        public void run() {
            for (int i = start; i > 0; i--) {
                if (s.getState()) {
                    System.out.println("W возвращает значение: " + i);
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            s.stop();
        }
    }

    public static void main (String[] args) {
        S s = new S();
        W w = new W(s);

        Thread threadS = new Thread(s);
        Thread threadW = new Thread(w);

        threadS.start();
        threadW.start();

        try {
            threadS.join();
            threadW.join();
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Завершен основной поток");
    }
}
