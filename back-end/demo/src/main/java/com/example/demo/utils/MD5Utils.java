package com.example.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Utils {
	public static String encrypt(String strSrc) {
		try {
			char[] hexChars = {
					'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f'
			};
			byte[] bytes = strSrc.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(bytes);
			bytes = md.digest();
			int j = bytes.length;
			char[] chars = new char[j*2];
			int k = 0;
			for(int i = 0; i < j; i++) {
				byte b = bytes[i];
				chars[k++] = hexChars[ b >>> 4 & 0xF];
				chars[k++] = hexChars[ b & 0xF ];
			}
			return new String(chars);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(MD5Utils.encrypt("password"));
	}
}
