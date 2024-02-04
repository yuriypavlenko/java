package generics.clazz;

public class B extends PageBC {

    public D submit() {
        System.out.println("B submitted and go to D");
        return new D();
    }
}
