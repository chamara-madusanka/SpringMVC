package com.pass.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppEncrypt {

	public static void main(String[] args) {
		String pass = "abc";
		int i = 0;
		while (i<10) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String hashVal = encoder.encode(pass);
			System.out.println(hashVal);
			i++;
		}
	}

}
