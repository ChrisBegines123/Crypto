/**
 * Interfaces for Crypto component.
 *
 * @author Christopher Begines
 * @dot begines.4
 */
public interface Crypto extends CryptoKernel {

    /**
     * Returns the current key.
     *
     * @return the current key
     * @ensures getKey = this.key
     */
    String getKey();

    /**
     * Clears the current key, leaving this component uninitialized.
     *
     * @clears this
     * @ensures this = empty
     */
    void clearKey();

    /**
     * Returns true if this component currently has a key set.
     *
     * @return true if a key exists
     * @ensures hasKey = [this.key is not empty]
     */
    boolean hasKey();

    /**
     * Encrypts and then hashes a message.
     *
     * @param message
     *            the message to encrypt and hash
     * @return combined encrypted-hash result
     * @requires this.key is initialized
     * @ensures encryptAndHash = hash(encrypt(message))
     */
    String encryptAndHash(String message);
}
