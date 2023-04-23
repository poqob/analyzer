/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 08.04.23
* @Messager 
* Messager stores messages and returns them according to Message headings.
*/
package handler.messager;

public class Messager {

	public static void send(Message msg) {
		_write(_getMessage(msg));
	}

	/*
	 * console messages according to console flags.
	 * 
	 * flags:
	 * 
	 * -h, --help | help
	 * 
	 * -a, --about | about
	 * 
	 */
	private static String _getMessage(Message msg) {
		switch (msg) {
		case noarg:
			return "\n No arguments provided, please re-launch for more information with --help or -h parameter";

		case help:
			return "\n java -jar codeparser.jar \r\n"
					+ " java -jar codeparser.jar [-h, --help](optional) : prints to screen possible launch parameters\r\n"
					+ " java -jar codeparser.jar [--about](optional) : prints to screen readme file content.\r\n"
					+ " java -jar codeparser.jar [test.java](required) : input file path\r\n"
					+ " java -jar codeparser.jar [example.java](required) [output path](optional) : path must be in this format -without quotes- \"output\\\\\"\r\n"
					+ " java -jar codeparser.jar [example.java](required) [-d, --debug](optional) :(debug mode), only gives console output with detailed information.\r\n"
					+ " java -jar codeparser.jar [example.java] (required)[-s, --show] (optional) : only gives console output as summery of the class.\n"
					+ " java -jar program.jar [example.java](required) [-s, --show] (required) [-c, --constructor] (optional) : writes constructors of the input file to console\r\n"
					+ " java -jar program.jar [example.java](required) [-s, --show] (required) [-m, --methods] (optional) : writes methods of input file to console\n";

		case wrong:
			return "\n wrong parameters dedected, please run with parameter -h or --help to see how to use\n";

		case about:
			return "\n It is a code parser console app/tool. Basicly parses classes and its components like functions and comments.\n"
					+ " CodeParser designed to scale. in further updates the parser will parse other languages,\n"
					+ " the parser will gain more functionality: i'll re-arrange console arguments to obtain input classes\n"
					+ " wanted components.\n"
					+ " like: java -jar codeparser.jar example.py [--get funs ~ --get class ~ --get constructor ~ --get libraries]\n"
					+ " developed by poqob, Mustafa BICER\n" + " github: https://github.com/poqob/analyzer\n"
					+ " supported languages: java (only java supported, i'll provide dart, python supports in further updates)\n"
					+ " version: 0.1\n";
		default:
			return " ";

		}
	}

	private static void _write(String msg) {
		System.out.print(msg);
	}
}
