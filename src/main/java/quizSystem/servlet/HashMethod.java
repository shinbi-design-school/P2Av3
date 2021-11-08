package quizSystem.servlet;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HashMethod  {
	public static void Hash(String password)throws NoSuchAlgorithmException{
		MessageDigest digest =MessageDigest.getInstance("SHA-256");
		byte[] passwordByte = digest.digest(password.getBytes());
		System.out.println(passwordByte);
		
		//ハッシュ値の確認
		MessageDigest testDigest = MessageDigest.getInstance("SHA-256");
		
		String testText1 = "暗号化するメッセージ";
		System.out.println(Arrays.equals(bt, testDigest.digest(testText1.getBytes())));
		
		String testText2 = "間違ったメッセージ";
		System.out.println(Arrays.equals(bt,testDigest.digest(testText2.getBytes())));
	}
}
