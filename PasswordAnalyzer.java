import java.util.Scanner;

public class PasswordAnalyzer {

    public static boolean hasGuessablePattern(String password) {
        String[] patterns = {"123", "abc", "password", "admin", "qwerty", "asdf"};
        password = password.toLowerCase();
        for (String pattern : patterns) {
            if (password.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    public static void analyzePassword(String password) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        boolean isLong = password.length() >= 8;
        boolean patternFound = hasGuessablePattern(password);

        String strength = "Weak";
        if (isLong && hasUpper && hasLower && hasDigit && hasSpecial && !patternFound) {
            strength = password.length() >= 12 ? "Strong" : "Medium";
        }

        System.out.println("\nPassword Strength: " + strength);

        // Suggest improvements
        if (strength.equals("Weak")) {
            System.out.println("Suggestions to improve:");
            if (!isLong) System.out.println("- Use at least 8 characters.");
            if (!hasUpper) System.out.println("- Add uppercase letters (A-Z).");
            if (!hasLower) System.out.println("- Add lowercase letters (a-z).");
            if (!hasDigit) System.out.println("- Add digits (0-9).");
            if (!hasSpecial) System.out.println("- Add special characters (!@#...).");
            if (patternFound) System.out.println("- Avoid common patterns like 123, abc, qwerty.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        analyzePassword(password);
    }
}