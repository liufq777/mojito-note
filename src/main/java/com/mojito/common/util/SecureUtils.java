package com.mojito.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 加密工具
 *
 * @author liufengqiang
 * @date 2020-10-26 09:45:11
 */
public class SecureUtils {

    /**
     * MD5加密
     */
    public static String md5(String msg) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(msg.getBytes(StandardCharsets.UTF_8));
        byte[] s = m.digest();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
        }
        return result;
    }

    /**
     * hmacSHA1
     *
     * @param key
     * @param text
     * @param charset
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
//    public static String hmacSHA1(String key, String text, String charset) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
//        Mac mac = Mac.getInstance("HmacSHA1");
//        mac.init(new SecretKeySpec(key.getBytes(charset), "HmacSHA1"));
//        return encode(mac.doFinal(text.getBytes(charset)));
//    }

    /**
     * Base64
     *
     * @param bstr
     * @return
     */
//    public static String encode(byte[] bstr) {
//        String sp = System.getProperty("line.separator");
//        return (new BASE64Encoder().encode(bstr)).replaceAll(sp, "");
//    }

    /**
     * 利用java原生的类实现SHA256加密
     */
    public static String SHA256(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest;
        String encodestr;
        messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes("UTF-8"));
        encodestr = byte2Hex(messageDigest.digest());
        return encodestr;
    }

    /**
     * 将byte转为16进制
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuilder.append("0");
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }

    /**
     * RSA加密
     */
    public static String rsaEncrypt(byte[] publicKey, String content) throws Exception {
        // 公钥X.509编码
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKey);
        PublicKey pubKey = KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);

        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, pubKey);

        // 获取加密内容并进行BASE64编码
        return new BASE64Encoder().encode(rsaCipher.doFinal(content.getBytes()));
    }

    /**
     * RSA解密
     */
    public static String rsaDecrypt(byte[] privateKey, String content) throws Exception {
        // 密钥PKCS#8编码
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKey);
        PrivateKey privateKeyStr = KeyFactory.getInstance("RSA").generatePrivate(privateKeySpec);

        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.DECRYPT_MODE, privateKeyStr);

        // 获取解密内容并BASE64解码
        return new String(rsaCipher.doFinal(new BASE64Decoder().decodeBuffer(content)));
    }

    /**
     * 签名
     */
    public static String sign(byte[] privateKey, String content, String charset) throws Exception {
        // 密钥PKCS#8编码
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKey);
        PrivateKey priKey = KeyFactory.getInstance("RSA").generatePrivate(privateKeySpec);

        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(priKey);

        // 设置字符集
        if (charset == null || charset.length() == 0) {
            signature.update(content.getBytes());
        } else {
            signature.update(content.getBytes(charset));
        }

        // 生成签名并BASE64编码
        return new String(new BASE64Encoder().encode(signature.sign()));
    }


    /**
     * 签名验证
     */
    public static boolean checkSign(byte[] publicKey, String content, String sign, String charset) throws Exception {
        // 公钥X.509编码
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKey);
        PublicKey pubKey = KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);

        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initVerify(pubKey);

        // 设置字符集
        if (charset == null || charset.length() == 0) {
            signature.update(content.getBytes());
        } else {
            signature.update(content.getBytes(charset));
        }

        // 将签名BASE64解码后验证
        return signature.verify(new BASE64Decoder().decodeBuffer(sign));
    }

    public static void main(String[] args) throws Exception {
        String content = "有内鬼，停止交易";
        System.out.println("MD5: " + md5(content));
        rsaTest(content);
    }

    private static void rsaTest(String content) throws Exception {
        //生成密钥对
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        //设置key的长度
        rsa.initialize(1024);
        KeyPair keyPair = rsa.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        //RSA加解密过程
        //1. 甲要发一段文字或数据给乙，先用公钥对文字进行加密
        String encrypt = rsaEncrypt(publicKey.getEncoded(), content);
        System.out.println("RSA：加密=" + encrypt);

        //2. 丙拦截到甲的密文后没有私钥无法解开，看不到明文，但是他可以伪造内容用同样的公钥加密后替换密文发给乙，所以甲需要用自己的私钥对数据签名
        String sign = sign(privateKey.getEncoded(), content, null);
        System.out.println("RSA：签名=" + sign);

        //3. 乙收到密文后（可能是甲发的正确的，也可能是丙伪造的）使用甲公开的公钥对签名进行校验，丙由于没有甲的私钥，用甲的公钥签名肯定通不过，于是防止了伪造
        boolean checkSign = checkSign(publicKey.getEncoded(), content, sign, null);
        System.out.println("RSA：签名验证=" + checkSign);

        //4. 乙校验通过后使用乙私钥解密得到数据
        String decrypt = rsaDecrypt(privateKey.getEncoded(), encrypt);
        System.out.println("RSA：解密=" + decrypt);
    }
}
