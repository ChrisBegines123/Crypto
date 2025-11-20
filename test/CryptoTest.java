public class CryptoTest {
        public static void main(String[] args) {

                System.out.println("=== CRYPTO TEST START ===");

                // ---------------------------------------------
                // 1. Construction & hasKey()
                // ---------------------------------------------
                Crypto c = new Crypto1L();
                System.out.println(
                                "1. Has key? (expected false): " + c.hasKey());

                // ---------------------------------------------
                // 2. setKey(), hasKey(), getKey()
                // ---------------------------------------------
                c.setKey("HELLO123");
                System.out.println(
                                "2a. Has key? (expected true): " + c.hasKey());
                System.out.println(
                                "2b. Key (expected HELLO123): " + c.getKey());

                // ---------------------------------------------
                // 3. encrypt(message)
                // ---------------------------------------------
                String plaintext = "attack at dawn";
                String encrypted = c.encrypt(plaintext);
                System.out.println("3. Encrypted text: " + encrypted);

                // ---------------------------------------------
                // 4. decrypt(ciphertext)
                // ---------------------------------------------
                String decrypted = c.decrypt(encrypted);
                System.out.println("4. Decrypted (expected attack at dawn): "
                                + decrypted);

                // ---------------------------------------------
                // 5. Hash function
                // ---------------------------------------------
                String hash = c.hash("hello");
                System.out.println("5. Hash of 'hello': " + hash);

                // ---------------------------------------------
                // 6. Round-trip test: decrypt(encrypt(x)) == x
                // ---------------------------------------------
                boolean roundTrip = plaintext
                                .equals(c.decrypt(c.encrypt(plaintext)));
                System.out.println("6. Round trip works? (expected true): "
                                + roundTrip);

                // ---------------------------------------------
                // 7. generateKey()
                // ---------------------------------------------
                c.generateKey();
                String newKey = c.getKey();
                System.out.println("7. Generated key (length 16): " + newKey
                                + " (len=" + newKey.length() + ")");

                // ---------------------------------------------
                // 8. clear()
                // ---------------------------------------------
                c.clear();
                System.out.println("8. After clear, hasKey? (expected false): "
                                + c.hasKey());

                // ---------------------------------------------
                // 9. transferFrom()
                // ---------------------------------------------
                Crypto a = new Crypto1L();
                Crypto b = new Crypto1L();

                a.setKey("ABC123");
                System.out.println("9a. A before transfer: " + a.getKey());
                System.out.println(
                                "9b. B before transfer has key? (expected false): "
                                                + b.hasKey());

                b.transferFrom(a);

                System.out.println(
                                "9c. A after transfer has key? (expected false): "
                                                + a.hasKey());
                System.out.println(
                                "9d. B after transfer key (expected ABC123): "
                                                + b.getKey());

                System.out.println("=== CRYPTO TEST END ===");
        }
}
