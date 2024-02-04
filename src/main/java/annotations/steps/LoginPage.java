package annotations.steps;

import java.lang.reflect.Method;

public class LoginPage {

    public LoginPage() {
        Method[] methods = this.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Step.class)) {
                Step anno = method.getDeclaredAnnotation(Step.class);
                System.out.print(method.getName());
                System.out.print(" | ");
                System.out.println(anno.title());
                if (!anno.description().equals(""))
                    System.out.println(anno.description());
                System.out.println("--------------\n");
            }
        }
    }

    @Step(title = "Type Email into Email field", description = "Typing Email of registered user")
    public LoginPage typeEmail(String email) {
        System.out.println("Typing email..." + email);
        return this;
    }

    @Step(title = "Type password into Password field")
    public LoginPage typePass(String password) {
        System.out.println("Typing password..." + password);
        return this;
    }

    @Step(title = "Submit form")
    public void submit() {
        System.out.println("Submitting form...");
    }
}
