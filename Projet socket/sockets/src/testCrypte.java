import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class testCrypte {
	public static void main(String arg[]) throws Exception{
		//byte[] data = "HELLO WORLD!".getBytes();
		KeyGenerator kg = null;
		Key key = null;
		Cipher cipher = null;
		try {
			kg = KeyGenerator.getInstance("DES");
			key = kg.generateKey();
			cipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}		
		
		crypte c = new crypte();
		c.chiffrement();
		c.dechiffrement();
	}
}
