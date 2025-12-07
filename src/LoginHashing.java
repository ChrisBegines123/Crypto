import components.crypto.Crypto;
import components.crypto.Crypto1L;

public class LoginHashing {

    public static void main(String[] args) {

        Crypto c = new Crypto1L();
        c.setKey("LOGINKEY");

        String passwordAttempt = "hunter2";
        String digest1 = c.encryptAndHash(passwordAttempt);

        System.out.println("Initial hash with current key:");
        System.out.println(digest1);

        c.generateKey();
        String digest2 = c.encryptAndHash(passwordAttempt);

        System.out.println("\nHash after key rotation:");
        System.out.println(digest2);

        boolean same = digest1.equals(digest2);
        System.out.println("\nDo hashes match? " + same);
    }
}
