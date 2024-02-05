package lambda.standardFI;

import java.util.function.Consumer;

public class ConsumerTest {

    static class MyObj {
        private boolean value = false;

        public void setValue(boolean value) {
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // change object lambda
        Consumer<MyObj> setTrue = (MyObj object) -> object.setValue(true);
        MyObj obj = new MyObj();
        System.out.println("obj value: " + obj.getValue());
        setTrue.accept(obj);
        System.out.println("obj value: " + obj.getValue());
    }
}
