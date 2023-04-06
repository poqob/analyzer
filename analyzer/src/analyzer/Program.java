package analyzer;

import java.io.IOException;
import java.util.Scanner;

import models.classes.java.JavaClass;
import parser.java.JavaParser;
import util.Todo;
import writer.javaWriter.JavaWriter;

@Todo("if a real function have commeted and located in a comment but classified as a function!!!!")

//java -jar test.jar C:\Users\mmerm\git\repository\analyzer\src\test\test.txt arg1=write destinition_path default= local
public class Program {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		if (args.length == 0)
			System.out.println("No arguments provided.");
		else {
			JavaParser parser = new JavaParser(args[0]);
			JavaClass clss = parser.parse();
			JavaWriter writer = new JavaWriter(clss);

			writer.writeToConsole();
			writer.writeToFile();

		}
		scanner.nextLine();
		scanner.close();
	}

}
