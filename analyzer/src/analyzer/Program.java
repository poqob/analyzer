package analyzer;

import java.io.IOException;
import java.util.Scanner;

import test.Test;
import util.Todo;

@Todo("if a real function have commeted and located in a comment but classified as a function!!!!")

//java -jar test.jar C:\Users\mmerm\git\repository\analyzer\src\test\test.txt
public class Program {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Test t;

		// args[0] = "C:\\Users\\mmerm\\git\\repository\\analyzer\\src\\test\\test.txt";

		if (args.length == 0)
			System.out.println("No arguments provided.");
		else {
			t = new Test(args[0]);

		}
		scanner.nextLine();
		scanner.close();
	}

}
