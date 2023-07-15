import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            // ASCII
            Validator.check("qwe_", "qwe", "qwe");

            System.out.println("Логин успешно выполнен!");
        } catch (WrongLoginException | WrongPasswordException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Файнали!");
        }
    }
}