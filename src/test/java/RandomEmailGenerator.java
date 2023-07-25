import java.util.Random;
public class RandomEmailGenerator {
    private static final String EMAIL_DOMAIN = "@test.com";
    private static final String NAME_PREFIX = "agnes";

    public static String generateRandomEmail() {
        StringBuilder sb = new StringBuilder();

        // Append name prefix
        sb.append(NAME_PREFIX);

        // Generate random three-digit numbers
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100; // Generates a random number between 100 and 999
        sb.append(randomNumber);

        // Append the domain
        sb.append(EMAIL_DOMAIN);

        return sb.toString();
    }

    public static void main(String[] args) {
        String randomEmail = generateRandomEmail();
        System.out.println(randomEmail);
    }
}
