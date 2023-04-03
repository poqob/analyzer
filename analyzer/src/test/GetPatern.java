package test;

import java.util.regex.Pattern;

public class GetPatern {
	public static Pattern getPatern(Paterns patern) {
		switch (patern) {
		case single:
			return Pattern.compile("//.*$");

		default:
			return Pattern.compile("//.*$");
		}

	}

	public static void _writer(String message) {
		System.out.print(message);
	}

}
