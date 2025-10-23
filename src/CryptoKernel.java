/**
 * Kernel interface for Crypto component.
 *
 * @author Christopher Begines
 * @dot begines.4
 */
public interface CryptoKernel extends Standard<Crypto> {

    /**
     * Sets the symmetric key to be used for encryption/decryption.
     *
     * @param key
     *            the key value to set
     * @updates this
     * @ensures this.key = key
     */
    void setKey(String key);

    /**
     * Encrypts a message using the current key.
     *
     * @param message
     *            the plaintext message to encrypt
     * @return the ciphertext
     * @requires key is initialized
     * @ensures encrypt = [encrypted version of message under this.key]
     */
    String encrypt(String message);

    /**
     * Decrypts a message using the current given key.
     *
     * @param ciphertext
     *            the encrypted message to decrypt
     * @return the decrypted plaintext
     * @requires key is initialized and ciphertext is valid
     * @ensures decrypt = [plaintext corresponding to ciphertext under this.key]
     */
    String decrypt(String ciphertext);

    /**
     * Generates a new random key and stores it in this component.
     *
     * @updates this
     * @ensures this.key = [randomly generated key]
     */
    void generateKey();

    /**
     * Hashes a given message using a simple one way function.
     *
     * @param message
     *            the inputted message to hash
     * @return the computed hash
     * @ensures hash = [one-way digest of message]
     */
    String hash(String message);
}
