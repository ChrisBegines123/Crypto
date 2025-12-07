package components.crypto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Crypto1LTest {

    private Crypto createCrypto() {
        return new Crypto1L();
    }

    @Test
    public void testConstructor() {
        Crypto c = this.createCrypto();
        assertFalse(c.hasKey());
        assertEquals("", c.getKey());
    }

    @Test
    public void testSetKeyBasic() {
        Crypto c = this.createCrypto();
        c.setKey("ABC123");
        assertTrue(c.hasKey());
        assertEquals("ABC123", c.getKey());
    }

    @Test
    public void testEncryptDecryptRoundTrip() {
        Crypto c = this.createCrypto();
        c.setKey("HELLO");
        String msg = "attack at dawn";
        String ct = c.encrypt(msg);
        String pt = c.decrypt(ct);
        assertEquals(msg, pt);
    }

    @Test
    public void testEncryptDifferentFromPlaintext() {
        Crypto c = this.createCrypto();
        c.setKey("HELLO");
        String msg = "abc";
        String ct = c.encrypt(msg);
        assertNotEquals(msg, ct);
    }

    @Test
    public void testDecryptKnownCiphertext() {
        Crypto c = this.createCrypto();
        c.setKey("XKEY");
        String msg = "test";
        String ct = c.encrypt(msg);
        String pt = c.decrypt(ct);
        assertEquals(msg, pt);
    }

    @Test
    public void testGenerateKeyLength() {
        Crypto c = this.createCrypto();
        c.generateKey();
        assertTrue(c.hasKey());
        assertEquals(16, c.getKey().length());
    }

    @Test
    public void testGetKeyEmptyWhenNoKey() {
        Crypto c = this.createCrypto();
        assertEquals("", c.getKey());
    }

    @Test
    public void testClear() {
        Crypto c = this.createCrypto();
        c.setKey("XYZ");
        c.clear();
        assertFalse(c.hasKey());
        assertEquals("", c.getKey());
    }

    @Test
    public void testNewInstanceEmpty() {
        Crypto c = this.createCrypto();
        c.setKey("AAA");
        Crypto d = c.newInstance();
        assertFalse(d.hasKey());
        assertEquals("", d.getKey());
    }

    @Test
    public void testTransferFrom() {
        Crypto a = this.createCrypto();
        Crypto b = this.createCrypto();
        a.setKey("SECRET");
        b.transferFrom(a);
        assertFalse(a.hasKey());
        assertTrue(b.hasKey());
        assertEquals("SECRET", b.getKey());
    }

    @Test
    public void testHash() {
        Crypto c = this.createCrypto();
        String h = c.hash("abc");
        assertEquals("cba3", h);
    }

    @Test
    public void testHasKeyTrueAfterSetKey() {
        Crypto c = this.createCrypto();
        c.setKey("KEY");
        assertTrue(c.hasKey());
    }
}
