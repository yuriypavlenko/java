package generics.method;

public class C extends PageBC {
    public D submit() {
        System.out.println("C submitted and go to D");
        return new D();
    }
}
