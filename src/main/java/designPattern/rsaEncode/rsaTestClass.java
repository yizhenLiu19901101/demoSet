package designPattern.rsaEncode;

import designPattern.utils.LoggerUtil;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class rsaTestClass {

    private static String PUBLIC_KEY_FILE = "PublicKey.key";
    /** 指定私钥存放文件 */
    private static String PRIVATE_KEY_FILE = "PrivateKey.key";


    public static void main(String[] args) throws Exception{
        // 生成密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();

        ObjectOutputStream oos1 = null;
        ObjectOutputStream oos2 = null;
        oos1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
        oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
        oos1.writeObject(rsaPublicKey);
        oos2.writeObject(rsaPrivateKey);

        // 格式化私钥
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");  // 确定算法
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  // 确定加密密钥
        byte[] result = cipher.doFinal("原文".getBytes());  // 加密
        LoggerUtil.info(Base64.encodeBase64String(result));
        // 格式化公钥
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        cipher = Cipher.getInstance("RSA"); // 确定算法
        cipher.init(Cipher.DECRYPT_MODE, publicKey);  // 确定公钥
        LoggerUtil.info(new String(cipher.doFinal(result))); // 解密

        byte[] publicKeyBytes= publicKey.getEncoded();
        String publicKeyBase64=Base64.encodeBase64String(publicKeyBytes);
        LoggerUtil.info("publicKeyBase64:"+publicKeyBase64);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));

        PublicKey key = (PublicKey) ois.readObject();
        LoggerUtil.info("********************************************************************");

        publicKeyBytes = key.getEncoded();
        publicKeyBase64 = Base64.encodeBase64String(publicKeyBytes);
        LoggerUtil.info("publicKeyBase64:"+publicKeyBase64);
    }
}
