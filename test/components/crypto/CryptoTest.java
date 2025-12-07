package components.crypto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CryptoTest {

        private Crypto c;

        @Before
        public void setUp() {
                this.c = new Crypto1L();
        }

        @Test
        public void testInitialState() {
                assertFalse(this.c.hasKey());
                assertEquals("", this.c.getKey());
        }

        @Test
        public void testSetKey() {
                this.c.setKey("KEY123");
                assertTrue(this.c.hasKey());
                assertEquals("KEY123", this.c.getKey());
        }

        @Test
        public void testEncryptDecrypt() {
                this.c.setKey("HELLO");
                String msg = "abc";
                String ct = this.c.encrypt(msg);
                String pt = this.c.decrypt(ct);
                assertEquals(msg, pt);
        }

        @Test
        public void testEncryptNotPlaintext() {
                this.c.setKey("HELLO");
                String msg = "abc";
                assertNotEquals(msg, this.c.encrypt(msg));
        }

        @Test
        public void testHash() {
                assertEquals("cba3", this.c.hash("abc"));
        }

        @Test
        public void testEncryptAndHash() {
                this.c.setKey("A");
                String out = this.c.encryptAndHash("hello");
                assertNotNull(out);
                assertFalse(out.isEmpty());
        }

        @Test
        public void testGenerateKey() {
                this.c.generateKey();
                assertTrue(this.c.hasKey());
                assertEquals(16, this.c.getKey().length());
        }

        @Test
        public void testClear() {
                this.c.setKey("X");
                this.c.clear();
                assertFalse(this.c.hasKey());
                assertEquals("", this.c.getKey());
        }

        @Test
        public void testTransferFrom() {
                Crypto a = new Crypto1L();
                a.setKey("ZZZ");
                this.c.transferFrom(a);
                assertTrue(this.c.hasKey());
                assertEquals("ZZZ", this.c.getKey());
                assertFalse(a.hasKey());
        }
}
