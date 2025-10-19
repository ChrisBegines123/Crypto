public class CryptoComponentProof {

    // Example key used for both the symmetric and asymmetric demo
    private int key = 7;

    // simple hash
    public int hash(String message) {
        int hash = 0;
        int prime = 31;
        for (int i = 0; i < message.length(); i++) {
            hash = (hash * prime + message.charAt(i)) % 1000000007;
        }
        return hash;
    }

    // Symmetric cipher XOR encryption
    public String encryptXOR(String message) {
        char[] result = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            result[i] = (char) (message.charAt(i) ^ this.key);
        }
        return new String(result);
    }

    // Symmetric cipher xor decryption
    public String decryptXOR(String ciphertext) {
        // XOR reverse is itself, so just calls encrypt
        return this.encryptXOR(ciphertext);
    }

    // asymmetric demo modular exponentiation
    public long modExp(long base, long exp, long mod) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result = (result * base) % mod;
        }
        return result;
    }

    // --- Demo main ---
    public static void main(String[] args) {
        CryptoComponentProof c = new CryptoComponentProof();

        String message = "Hello Software 2 Class";
        System.out.println("Original: " + message);

        // Symmetric demo
        String encrypted = c.encryptXOR(message);
        String decrypted = c.decryptXOR(encrypted);
        System.out.println("XOR Encrypted: " + encrypted);
        System.out.println("XOR Decrypted: " + decrypted);

        // Hash demo
        System.out.println("Hash: " + c.hash(message));

        // Asymmetric demo (toy RSA-like)
        long base = 5, exp = 3, mod = 13;
        System.out
                .println("Modular exponentiation: " + c.modExp(base, exp, mod));
    }
}
