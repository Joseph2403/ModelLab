import java.util.Scanner;
import javax.crypto.*;

public class DES {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter message to Encrypt: ");
            String message = sc.nextLine();
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            byte[] text = message.getBytes();
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = desCipher.doFinal(text);
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);
            System.out.println("Message [Byte Format] : " + text);
            System.out.println("Message : " + new String(text));
            System.out.println("Encrypted Message: " + new String(textEncrypted));
            System.out.println("Decrypted Message: " + new String(textDecrypted));
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}