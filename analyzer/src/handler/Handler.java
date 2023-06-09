/**
*
* @author Mustafa B��ER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @Handler 
* Handler handles situations which comes from console by users.
*/

package handler;

import java.util.Scanner;

import handler.extensions.Extensions;
import handler.languages.LanguageHandler;
import handler.messager.Message;
import handler.messager.Messager;
import handler.program.ProgramMode;

public class Handler {

	// handling flow according to given console parameters.
	public static void handle(String[] args) throws Exception {
		if (args.length == 0)
			Messager.send(Message.noarg);
		else if (args.length == 1)
			_one(args[0]);
		else if (args.length == 2)
			_two(args);
		else if (args.length == 3)
			_three(args);
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
		// to see help documentation.
		if (arg.equals("-h") || arg.equals("--help")) {
			Messager.send(Message.help);
			return;
		}
		// to see about codeparser documentation.
		if (arg.equals("-a") || arg.equals("--about")) {
			Messager.send(Message.about);
			return;
		}
		boolean match = false;
		// controlling if codeparser has input file support.
		for (Extensions extension : Extensions.values()) {
			if (arg.contains(extension.name())) {
				// go to handle language
				match = true;
				LanguageHandler.handler(extension, arg, ProgramMode.regular);
			}
		}
		if (!match)
			Messager.send(Message.wrong);

	}

	// java -jar program.jar [example.java](required) [output path](optional) : path
	// must be in this format -without quotes- "output\\"

	// java -jar program.jar [example.java](required) [-d, --debug](optional)
	// :(debug mode), only gives console output with detailed information.
	// arg0: input file, arg1: output destination
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
		// debug situation
		if (args[1].equals("-d") || args[1].equals("--debug") && match)
			LanguageHandler.handler(_extension, args[0], ProgramMode.debug);
		// only show on console
		else if (args[1].equals("-s") || args[1].equals("--show") && match)
			LanguageHandler.handler(_extension, args[0], ProgramMode.show);

		// show on console and write output to specifed path situation
		else if (match)
			LanguageHandler.handler(_extension, args[0], args[1]);
		// it will throw exception bu i'm tired :''
		else
			Messager.send(Message.wrong);

	}

	// arg0: input file
	// arg1: "-s" or "--show" flag
	// arg2: "-m" or "--methods" OR "-c" or "--constructors" flag
	private static void _three(String[] args) throws Exception {
		boolean match = false;
		Extensions _extension = null;
		// controlling if file is supported by program. (head up extensions.java)
		for (Extensions extension : Extensions.values()) {
			if (args[0].contains(extension.name())) {
				match = true;
				_extension = extension;
			}
		}

		if (args[1].equals("-s") || args[1].equals("--show") && match) {
			if (args[2].equals("-m") || args[2].equals("--methods") && match) {
				LanguageHandler.handler(_extension, args[0], ProgramMode.showMethods);
			}
			if (args[2].equals("-c") || args[2].equals("--constructors") && match) {
				LanguageHandler.handler(_extension, args[0], ProgramMode.showConstructors);
			}
		}

	}
}
