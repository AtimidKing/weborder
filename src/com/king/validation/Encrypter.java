package com.king.validation;

public class Encrypter {
	public static String md5Encypter(String string)throws Exception{
	
		java.security.MessageDigest md5=java.security.MessageDigest.getInstance("MD5");
		sun.misc.BASE64Encoder base64Encoder=new sun.misc.BASE64Encoder();
		return base64Encoder.encode(md5.digest(string.getBytes("utf-8")));
	}
}
