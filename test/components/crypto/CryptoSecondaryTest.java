package components.crypto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CryptoSecondaryTest {

    private Crypto createCrypto() {
        return new Crypto1L();
    }

    @Test
    public void testClearKey() {
        Crypto c = this.createCrypto();
        c.setKey("TESTING");
        c.clearKey();
        assertFalse(c.hasKey());
        assertEquals("", c.getKey());
    }

    @Test
    public void testEncryptAndHash() {
        Crypto c = this.createCrypto();
        c.setKey("KEY123");
        String msg = "hello";
        String result = c.encryptAndHash(msg);
        assertNotEquals("", result);
    }

    @Test
    public void testToStringBasic() {
        Crypto c = this.createCrypto();
        assertEquals("Crypto[keySet=false]", c.toString());
    }

    @Test
    public void testToStringAfterSetKey() {
        Crypto c = this.createCrypto();
        c.setKey("K");
        assertEquals("Crypto[keySet=true]", c.toString());
    }

    @Test
    public void testEqualsSameObject() {
        Crypto c = this.createCrypto();
        assertTrue(c.equals(c));
    }

    @Test
    public void testEqualsTwoDifferentObjects() {
        Crypto a = this.createCrypto();
        Crypto b = this.createCrypto();
        a.setKey("AAA");
        b.setKey("BBB");
        assertTrue(a.equals(b));
    }

    @Test
    public void testHashCodeSameForTwoObjects() {
        Crypto a = this.createCrypto();
        Crypto b = this.createCrypto();
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testHasKeyFalse() {
        Crypto c = this.createCrypto();
        assertFalse(c.hasKey());
    }

    @Test
    public void testHasKeyTrue() {
        Crypto c = this.createCrypto();
        c.setKey("X");
        assertTrue(c.hasKey());
    }
}
