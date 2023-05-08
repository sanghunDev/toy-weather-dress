package com.app;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class JasyptTest {

    @Test
    public void jasyptTest() {
        String password = "";
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();//멀티코어 시스템에서 해독을 병렬처리함
        encryptor.setPoolSize(4);   //poolSize는 머신의 코어수와 동일하게 설정하는게 좋다
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");   //암호화에 사용할 알고리즘
        String content = "";
        String encryptedContent = encryptor.encrypt(content);//암호화
        String decryptedContent = encryptor.decrypt(encryptedContent);
        System.out.println("암호화 = " + encryptedContent + " 복호화 = " + decryptedContent);

    }
}
