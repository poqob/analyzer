package handler.program;

import java.util.Scanner;

import handler.extensions.Extensions;
import handler.languages.LanguageHandler;
import handler.messager.Message;
import handler.messager.Messager;

public class Handler {

	public static void handle(String[] args) throws Exception {
		if (args.length == 0)
			Messager.send(Message.noarg);
		else if (args.length == 1)
			_one(args[0]);
		else if (args.length == 2)
			_two(args);
		else
			Messager.send(Message.help);
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nPress any key to exit.\n");
		scanner.nextLine();
		scanner.close();
	}

	// java -jar test.jar [-h, --help](optional) : prints to screen possible launch
	// parameters

	// java -jar test.jar [--about](optional) : prints to screen readme file
	// content.

	// java -jar test.jar [test.java](required) : input file path
	private static void _one(String arg) throws Exception {
		if (arg.equals("-h") || arg.equals("--help")) {
			Messager.send(Message.help);
			return;
		}
		if (arg.equals("-a") || arg.equals("--about")) {
			Messager.send(Message.about);
			return;
		}
		boolean match = false;
		for (Extensions extension : Extensions.values()) {
			if (arg.contains(extension.name())) {
				// go to handle language
				match = true;
				LanguageHandler.handler(extension, arg, Mode.regular);
			}
		}
		if (!match)
			Messager.send(Message.wrong);

	}

	// java -jar program.jar [example.java](required) [output path](optional) : path
	// must be in this format -without quotes- "output\\"

	// java -jar program.jar [example.java](required) [-d, --debug](optional)
	// :(debug mode), only gives console output with detailed information.

	private static void _two(String[] args) throws Exception {
		boolean match = false;
		Extensions _extension = null;
		// controlling if file is supported by program.
		for (Extensions extension : Extensions.values()) {
			if (args[0].contains(extension.name())) {
				match = true;
				_extension = extension;
			}
		}
		if (args[1].equals("-d") || args[1].equals("--debug") && match)
			LanguageHandler.handler(_extension, args[0], Mode.debug);
		else if (match)
			LanguageHandler.handler(_extension, args[0], args[1]);
		else
			Messager.send(Message.wrong);

	}
}
