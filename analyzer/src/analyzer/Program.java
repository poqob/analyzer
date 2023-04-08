package analyzer;

import java.util.Scanner;

import handler.program.Handler;
import util.Todo;

@Todo("if a real function have commeted and located in a comment but classified as a function!!!!")

//java -jar test.jar 
//java -jar test.jar [-h, --help](optional) : prints to screen possible launch parameters
//java -jar test.jar [--about](optional) : prints to screen readme file content.
//java -jar test.jar [test.java](required) : input file path
//java -jar program.jar [example.java](required) [output path](optional) : path must be in this format -without quotes- "output\\"
//java -jar program.jar [example.java](required) [-d, --debug](optional) :(debug mode), only gives console output with detailed information.

public class Program {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Handler.handle(args);
		scanner.nextLine();
		scanner.close();
	}

}
