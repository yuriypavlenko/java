package lambda.standardFI;

import java.util.function.Function;

public class FunctionTest {

    static class MyObj {
        private boolean value = false;

        public void setValue(boolean value) {
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }
    }

    static class MyObjBuilder {
        private boolean value = false;

        public void setValue(boolean value) {
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Function<MyObjBuilder, MyObj> createObj = (builder) -> {
            boolean val = builder.getValue();
            MyObj newObj = new MyObj();
            newObj.setValue(val);
            return newObj;
        };

        MyObj obj1 = new MyObj();
        System.out.println("obj1 with: " + obj1.getValue());

        MyObjBuilder builder = new MyObjBuilder();
        builder.setValue(true);

        MyObj obj2 = createObj.apply(builder);
        System.out.println("obj2 with: " + obj2.getValue());
    }
}
