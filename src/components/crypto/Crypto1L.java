package components.crypto;

import java.util.Random;

/**
 * Kernel implementation for the Crypto component.
 *
 * Representation is this.key: String
 *
 * @convention this.key may be null - If this.key is not null, then it must be a
 *             non-empty String
 *
 *             Correspondence: - If this.key == null, then the abstract state is
 *             "empty" / nokey - If this.key is not null, the abstract key =
 *             this.key
 *
 * @author Christopher Begines
 * @dot begines.4
 */
public class Crypto1L extends CryptoSecondary {

    /**
     * Private representation of the key.
     */
    private String key;

    /**
     * No-argument constructor. Initializes the component with when no key set.
     */
    public Crypto1L() {
        this.key = null;
    }

    /**
     * Kernel method: setKey
     */
    @Override
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Kernel method: encrypt the message
     *
     * This uses a simple Caesar-shift style transformation based on the key's
     * hashCode.
     */
    @Override
    public String encrypt(String message) {
        if (this.key == null) {
            throw new IllegalStateException("The Key not initialized.");
        }

        int shift = Math.abs(this.key.hashCode() % 26);
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            result.append((char) (c + shift));
        }

        return result.toString();
    }

    @Override
    public String decrypt(String ciphertext) {
        if (this.key == null) {
            throw new IllegalStateException("Key not initialized.");
        }

        int shift = Math.abs(this.key.hashCode() % 26);
        StringBuilder result = new StringBuilder();

        for (char c : ciphertext.toCharArray()) {
            result.append((char) (c - shift));
        }

        return result.toString();
    }

    /**
     * Kernel method: generateKey()
     *
     * Creates a random 16-character alphanumeric key.
     */
    @Override
    public void generateKey() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand = new Random();
        StringBuilder generated = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            generated.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }

        this.key = generated.toString();
    }

    @Override
    public boolean hasKey() {
        return this.key != null && !this.key.isEmpty();
    }

    @Override
    public String getKey() {
        return (this.key == null) ? "" : this.key;
    }

    /**
     * Kernel method: hash(message)
     *
     * A simple hash: reverses the string + adds the hex length tag.
     */
    @Override
    public String hash(String message) {
        String reversed = new StringBuilder(message).reverse().toString();
        return reversed + Integer.toHexString(message.length());
    }

    // ------------------------------------------------------------
    // Standard methods
    // ------------------------------------------------------------

    /**
     * Clears the representation.
     */
    @Override
    public void clear() {
        this.key = null;
    }

    /**
     * Creates a new, empty Crypto1L instance.
     */
    @Override
    public Crypto newInstance() {
        return new Crypto1L();
    }

    /**
     * Transfers the state from another Crypto object.
     */
    @Override
    public void transferFrom(Crypto source) {
        Crypto1L local = (Crypto1L) source;
        this.key = local.key;
        local.key = null;
    }
}
