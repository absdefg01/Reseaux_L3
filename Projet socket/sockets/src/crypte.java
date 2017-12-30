import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class crypte {
	private byte[] data;
	private byte[] result;
	private byte[] original;
	private KeyGenerator kg;
	private Key key;
	private Cipher cipher;
	
	public crypte(byte[] data, KeyGenerator kg, Key key, Cipher cipher){
		data = this.data;
		kg = this.kg;
		key = this.key;
		cipher = this.cipher;
	}
	
	public crypte() throws Exception{
		data = "HELLO WORLD!".getBytes();
		kg = KeyGenerator.getInstance("DES");
		key = kg.generateKey();
		cipher = Cipher.getInstance("DES");
	}
	
    public void chiffrement() throws Exception{
    		cipher.init(Cipher.ENCRYPT_MODE, this.key);
    		result = cipher.doFinal(this.data);
    		System.out.println("Encrypted data : " + new String(result));
    }
    
    public void dechiffrement() throws Exception{
    		cipher.init(Cipher.DECRYPT_MODE, key);
    		original = cipher.doFinal(result);
    		System.out.println("Decrypted data : " + new String(original));
    	
    }
}
