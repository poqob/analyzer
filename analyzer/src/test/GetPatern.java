package test;

import java.util.regex.Pattern;

public class GetPatern {
	public static Pattern getPatern(Paterns patern) {
		switch (patern) {
		case single:
			return Pattern.compile("//.*$");
		case multi:
			return Pattern.compile("/\\*(.|\\n)*?\\*/");
		case javadoc:
			return Pattern.compile("/\\*\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/");
		default:
			return Pattern.compile("//.*$");
		}

	}
}
