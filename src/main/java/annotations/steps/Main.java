package annotations.steps;

public class Main {
    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();

        loginPage
                .typeEmail("test@test.com")
                .typePass("12345678")
                .submit();
    }
}
