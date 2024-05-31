package Client;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
    public static String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, digest);
            return number.toString(16);
        } catch (NoSuchAlgorithmException e) {
            return "Такого алгоритма хэширования не существует.";
        }
    }
}
