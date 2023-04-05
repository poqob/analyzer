package parser.patterns.java;

import java.util.regex.Pattern;

public class GetPatern {
	public static String className;

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
		case classes:
			return Pattern.compile("^\\s*(public|private|protected)?\\s*(abstract)?\\s*class\\s+" + className
					+ "\\s*(?:extends\\s+\\w+)?\\s*(?:implements\\s+\\w+(?:,\\s*\\w+)*)?\\s*\\{");
		default:
			return Pattern.compile("//.*$");
		}
	}
}
//method
//Pattern.compile("(public|private|protected)?\\s+static?\\s+\\w+\\s+(\\w+)\\s*\\([^\\)]*\\)\\s*\\{");