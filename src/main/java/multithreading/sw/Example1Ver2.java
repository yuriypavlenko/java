package multithreading.sw;

public class Example1Ver2 {

    static class State {
        private boolean state = false;
        private boolean stop = false;

        synchronized public void setState(boolean newState) {
            state = newState;

            if (newState) {
                System.out.println("Продолжаем");
                notifyAll();
            }
        }

        synchronized public boolean getState() {
            if (!state) {
                try {
                    System.out.println("Жди");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return state;
        }

        public void stop() {
            stop = true;
        }
    }

    static class S implements Runnable {
        State state;
        boolean newState;

        public S(State state) {
            this.state = state;
        }
        public void run() {
            while (!state.stop) {
                newState = !newState;
                state.setState(newState);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("S stopped!");
        }
    }

    static class W implements Runnable {
        State state;

        public W(State state) {
            this.state = state;
        }
        int start = 30;
        public void run() {
            for (int i = start; i > 0; i--) {
                if (state.getState()) {
                    System.out.println("W возвращает значение: " + i);
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            state.stop();
        }
    }

    public static void main (String[] args) {
        State state = new State();
        S s = new S(state);
        W w = new W(state);

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
