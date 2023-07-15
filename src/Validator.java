import java.util.regex.Pattern;

public class Validator {

    private static final String ALLOWED_CHARS = "abcdefgqwe_";
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z0-9_]+$");

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть больше 20 символов!");
        }
        if (!PATTERN.matcher(login).matches()) {
            throw new WrongLoginException("Строка содержит недопустимые символы!");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль не может быть больше 20 символов!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не равны!");
        }
        if (!checkWithRegex(password)) {
            throw new WrongPasswordException("Строка содержит недопустимые символы!");
        }
    }

    private static void checkAlphabet3(String login) {
        for (int i = 0; i < login.length(); i++) {
            char c = Character.toLowerCase(login.charAt(i));
            // ASCII
            if ((c >= 'a' && c <= 'z') || c == '_' || c >= '0' && c <= '9') {
                continue;
            }
            throw new WrongLoginException("Логин не может быть больше 20 символов!");
        }
    }

    private static boolean checkWithRegex(String str) {
        return str.matches("[a-zA-Z0-9_]+$");
    }

    private static boolean checkAlphabet(String str) {
        var lowercase = str.toLowerCase();
        for (int i = 0; i < lowercase.length(); i++) {
            var c = lowercase.charAt(i);
            for (int j = 0; j < ALLOWED_CHARS.length(); j++) {
                if (ALLOWED_CHARS.charAt(j) == c) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkAlphabet2(String str) {
        var lowercase = str.toLowerCase();
        for (int i = 0; i < lowercase.length(); i++) {
            var c = lowercase.charAt(i);
            if (!ALLOWED_CHARS.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

}
