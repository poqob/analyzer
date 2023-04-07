/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @GetJavaPattern enum
* GetJavaPattern gives compiled pattern with propper regex exprasion.
* 
*/

package parser.patterns.java;

import java.util.regex.Pattern;

public class GetJavaPattern {
	// className field for constructor dedection and also provides helps method
	// dedection. attempted after java class parsing.
	public static String className;

	// returns propper pattern.
	public static Pattern getPatern(JavaPatterns pattern) {
		switch (pattern) {
		case single:
			return Pattern.compile("//.*$");
		case multi:
			return Pattern.compile("/\\*(?!\\*).{2}.*?\\*/", Pattern.DOTALL);
		case javadoc:
			return Pattern.compile("/\\*\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/");
		case method:
			return Pattern.compile("[A-Za-z]+.*[A-Za-z]+.*[A-Za-z]+\\(\\).*\\{", Pattern.CASE_INSENSITIVE);
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

//method without static
// (public|private|protected)?\s+\w+\s+(\w+)\s*\([^)]*\)\s*{

//method new
//  Pattern.compile("[A-Za-z]+.*[A-Za-z]+.*[A-Za-z]+\\(\\).*\\{", Pattern.CASE_INSENSITIVE);
