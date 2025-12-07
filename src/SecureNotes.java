import components.crypto.Crypto;
import components.crypto.Crypto1L;

public class SecureNotes {

    public static void main(String[] args) {

        Crypto c = new Crypto1L();
        c.setKey("NOTES123");

        String note1 = "Meet at 3PM";
        String note2 = "Project deadline moved up";
        String note3 = "Buy groceries";

        String e1 = c.encrypt(note1);
        String e2 = c.encrypt(note2);
        String e3 = c.encrypt(note3);

        System.out.println("Encrypted notes:");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println("\nDecrypted notes:");
        System.out.println(c.decrypt(e1));
        System.out.println(c.decrypt(e2));
        System.out.println(c.decrypt(e3));
    }
}
