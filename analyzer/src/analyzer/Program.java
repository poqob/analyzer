package analyzer;

import java.io.IOException;
import java.util.Scanner;

import models.classes.java.JavaClass;
import parser.java.JavaParser;
import util.Debug;
import util.Todo;
import writer.javaWriter.JavaWriter;

@Todo("if a real function have commeted and located in a comment but classified as a function!!!!"

		+ "controll comment in comment situation: a multi comment or document comment"
		+ "may contain '\\', intrpreted as single line by java regex. ")

//java -jar test.jar test.java ..\\output\\
//java -jar test.jar argument0 argument1=local folder path
//java -jar program.jar example.java [-d~--debug] :(debug mode), only gives console output with detailed information.

public class Program {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		// controlling arguments
		if (args.length == 0)
			System.out.println("No arguments provided.");
		else {
			JavaParser parser = new JavaParser(args[0]);
			JavaClass clss = parser.parse();
			JavaWriter writer = new JavaWriter(clss);

			// if second argumend provided by user, run write to file with specified path
			// else create files into execute path.
			if (args.length == 2) {
				if ("-d".equals(args[1]) || "--debug".equals(args[1])) {
					writer.writeToConsole();
					Debug.Writer(clss.getStatics().concat("\n\n"));
					Debug.Writer(clss.toString().concat("\n\n"));
					Debug.Writer(clss.getFunComs());
				} else
					writer.writeToFile(args[1]);
			} else {
				writer.writeToConsole();
				writer.writeToFile();
			}
		}
		System.out.println("press any key to exit.\n");
		scanner.nextLine();
		scanner.close();
	}

}
