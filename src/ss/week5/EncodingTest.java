package ss.week5;

import org.apache.commons.codec.DecoderException;
import java.util.Base64;
import org.apache.commons.codec.binary.Hex;


/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "aaaaaaaaaaaaaaa";
        String hexInput = Hex.encodeHexString(input.getBytes());
        System.out.println(hexInput);
        
        byte[] encodingBytes = Base64.getEncoder().encode(hexInput.getBytes());
        System.out.println("Encoding in Base 64 is: " + new String(encodingBytes));
        
        byte[] decodingBytes = Base64.getDecoder().decode(encodingBytes);
        System.out.println("Decoding in Base 64 is: " + new String(decodingBytes));
        }
}
