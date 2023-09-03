import com.tiger.rbac.common.utils.JwtTokenUtil;
import com.tiger.rbac.common.utils.PasswordUtils;
import com.tiger.rbac.common.utils.RSAUtils;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Zenghu
 * @Date 2023年08月28日 22:39
 * @Description
 * @Version: 1.0
 **/
public class Test01 {

    @Test
    public void test01() throws NoSuchAlgorithmException {
        final String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace);
        final String encode = PasswordUtils.encode("12345", replace);
        System.out.println(encode);
    }


    @Test
    public void test011() throws NoSuchAlgorithmException {
        String salt = "1bd2cc6ab57e41d4ae74a6538a8c5084";
        String password = "12345";
        String encode = PasswordUtils.encode(password, salt);
        System.out.println(encode);
    }


    @Test
    public void test02() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", "admin");
        final String test = JwtTokenUtil.genToken("test", map);
        System.out.println(test);
    }


    @Test
    public void test03() throws NoSuchAlgorithmException {
        final String[] strings = RSAUtils.genKeyPair();
        // MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAotjBHz0bUkpzcfSbEK3tA+UzEaYz8sMB7varpvQnM0XkMQVBf9pMveYkZfWT+3mdxO/5PldZ21OECcTsmkdJowIDAQABAkBrF7axb4M3M+UF7QHJD0hOhn12PuHs5VexKiEqc2gQK/iOj5OPlx8VxpUYTRQNTxHJ/9t6hQcrlB9qJ+E0Ieo5AiEA6M6eOIwBb+VZJ9QwW7bGXRQRTorDN0kOowOLl9KVIY0CIQCzEefEj37xGGfbi3SRIbCyr/gTEVRkDFqvINOdnS2T7wIgK+2AsU7JnqF59yf0j/mm6D03HsjUGQRx/JRYrKcReKkCIADuhesy5/EvNFMjHZ8nsrirS7olq++9VLd2j0NRrwwHAiABZe1c+3W7++pSV6657HnvJc6lOQnhDD/KxB740+LSYw==
        // MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKLYwR89G1JKc3H0mxCt7QPlMxGmM/LDAe72q6b0JzNF5DEFQX/aTL3mJGX1k/t5ncTv+T5XWdtThAnE7JpHSaMCAwEAAQ==
        System.out.println(strings[0]);
        System.out.println(strings[1]);
    }

    @Test
    public void test04() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKLYwR89G1JKc3H0mxCt7QPlMxGmM/LDAe72q6b0JzNF5DEFQX/aTL3mJGX1k/t5ncTv+T5XWdtThAnE7JpHSaMCAwEAAQ==";
        String admin = RSAUtils.encryptByPublicKey(publicKey, "12345");
        // VEEPIDOA+EpDcym+2rHeXXIRZKzMgoIb0GRlDttzw+e/zKIXFrapFM4tW/jO/r64fMjI5zJc57Qdqll/ji2INg==
        System.out.println(admin);

        String privateKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAotjBHz0bUkpzcfSbEK3tA+UzEaYz8sMB7varpvQnM0XkMQVBf9pMveYkZfWT+3mdxO/5PldZ21OECcTsmkdJowIDAQABAkBrF7axb4M3M+UF7QHJD0hOhn12PuHs5VexKiEqc2gQK/iOj5OPlx8VxpUYTRQNTxHJ/9t6hQcrlB9qJ+E0Ieo5AiEA6M6eOIwBb+VZJ9QwW7bGXRQRTorDN0kOowOLl9KVIY0CIQCzEefEj37xGGfbi3SRIbCyr/gTEVRkDFqvINOdnS2T7wIgK+2AsU7JnqF59yf0j/mm6D03HsjUGQRx/JRYrKcReKkCIADuhesy5/EvNFMjHZ8nsrirS7olq++9VLd2j0NRrwwHAiABZe1c+3W7++pSV6657HnvJc6lOQnhDD/KxB740+LSYw==";
        final String decrypt = RSAUtils.decryptByPrivateKey(privateKey, admin);
        System.out.println(decrypt);

    }


}
