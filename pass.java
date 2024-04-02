import java.util.Random;
import java.util.Scanner;

public class pass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        
        System.out.print("Do you want to include uppercase letters? (yes/no): ");
        boolean includeUpperCase = scanner.next().equalsIgnoreCase("y");
        
        System.out.print("Do you want to include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");
        
        System.out.print("Do you want to include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includeUpperCase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Password: " + password);
    }

    private static String generatePassword(int length, boolean includeUpperCase, boolean includeNumbers, boolean includeSpecialChars) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";
        
        StringBuilder allCharsBuilder = new StringBuilder(lowercaseChars);
        if (includeUpperCase) {
            allCharsBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (includeNumbers) {
            allCharsBuilder.append(numbers);
        }
        if (includeSpecialChars) {
            allCharsBuilder.append(specialChars);
        }
        
        String allChars = allCharsBuilder.toString();
        
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }
}
