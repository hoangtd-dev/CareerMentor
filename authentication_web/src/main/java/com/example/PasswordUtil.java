package com.example;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
	private static final int LOG_ROUNDS = 12;

	public static String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(LOG_ROUNDS));
	}

	public static boolean verify(String password, String hash) {
		if (password == null || hash == null) {
			return false;
		}
		try {
			return BCrypt.checkpw(password, hash);
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
