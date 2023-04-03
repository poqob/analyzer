package test;

import java.util.regex.Pattern;

public class GetPatern {
	final static String className = "Test";

	public static Pattern getPatern(Paterns patern) {
		switch (patern) {
		case single:
			return Pattern.compile("//.*$");
		case multi:
			return Pattern.compile("/\\*(?!\\*).{2}.*?\\*/", Pattern.DOTALL);
		case javadoc:
			return Pattern.compile("/\\*\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/");
		case method:
			return Pattern.compile("(public|private|protected)?\\s+static?\\s+\\w+\\s+(\\w+)\\s*\\([^\\)]*\\)\\s*\\{");
		case constructor:
			return Pattern.compile("(public|protected|private)\\s+" + className + "\\s*\\(.*?\\)\\s*\\{");
		default:
			return Pattern.compile("//.*$");
		}

	}
}
