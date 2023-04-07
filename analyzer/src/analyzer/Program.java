package analyzer;

import java.io.IOException;
import java.util.Scanner;

import models.classes.java.JavaClass;
import parser.java.JavaParser;
import util.Todo;
import writer.javaWriter.JavaWriter;

@Todo("if a real function have commeted and located in a comment but classified as a function!!!!")

//java -jar test.jar test.java ..\\output\\
//java -jar test.jar argument0 argument1=local folder path

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

			// this method prints the requested(by homework) output to the screen
			writer.writeToConsole();

			// if second argumend provided by user, run write to file with specified path
			// else create files into execute path.
			if (args.length == 2)
				writer.writeToFile(args[1]);
			else
				writer.writeToFile();
		}
		System.out.println("press any key to exit.\n");
		scanner.nextLine();
		scanner.close();
	}

}
