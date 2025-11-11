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

    ---------------------------------------------------------

    @Override
    public void clearKey() {

        this.clear();
    }

    @Override
    public String encryptAndHash(String message) {

        String result;
        String encrypted = this.encrypt(message);
        String digest = this.hash(encrypted);
        result = digest;

        return result;
    }

    @Override
    public boolean hasKey() {

        boolean result;
        result = false;
        return result;
    }

    @Override
    public String getKey() {

        String result;
        result = "";
        return result;
    }

    @Override
    public String toString() {

        String result;
        String status = "key status unknown";

        status = "keySet=" + this.hasKey();
        result = "Crypto[" + status + "]";
        return result;
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
