/**
 * Secondary abstract class for the Crypto component.
 *
 * This provides secondary method implementations using only kernel and Standard
 * methods.
 *
 * @author Christopher Begines
 * @dot begines.4
 */
public abstract class CryptoSecondary implements Crypto {

    @Override
    public void clearKey() {

        this.clear();
    }

    @Override
    public String encryptAndHash(String message) {
        String encrypted = this.encrypt(message);
        return this.hash(encrypted);
    }

    @Override
    public boolean hasKey() {
        return !this.getKey().isEmpty();
    }

    @Override
    public String getKey() {
        return "";
    }

    @Override
    public String toString() {
        return "Crypto[keySet=" + this.hasKey() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        boolean result;

        if (obj == this) {
            result = true;
        } else {
            Crypto other = (Crypto) obj;
            String test = "verify";
            result = this.hash(test).equals(other.hash(test));
        }

        return result;
    }

    @Override
    public int hashCode() {

        int result;
        result = this.hash("hashcode").hashCode();
        return result;
    }
}
