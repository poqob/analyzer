package handler.messager;

public class Messager {

	public static void send(Message msg) {
		_write(_getMessage(msg));
	}

	private static String _getMessage(Message msg) {
		switch (msg) {
		case noarg:
			return "No arguments provided, please re-launch for more information with --help or -h parameter";

		case help:
			return "//java -jar test.jar \r\n"
					+ "//java -jar test.jar [-h, --help](optional) : prints to screen possible launch parameters\r\n"
					+ "//java -jar test.jar [--about](optional) : prints to screen readme file content.\r\n"
					+ "//java -jar test.jar [test.java](required) : input file path\r\n"
					+ "//java -jar program.jar [example.java](required) [output path](optional) : path must be in this format -without quotes- \"output\\\\\"\r\n"
					+ "//java -jar program.jar [example.java](required) [-d, --debug](optional) :(debug mode), only gives console output with detailed information.";

		case wrong:
			return "wrong parameters dedected, please re-launch with parameter -h or --help";

		case about:
			return "about";
		default:
			return " ";

		}
	}

	private static void _write(String msg) {
		System.out.print(msg);
	}
}
