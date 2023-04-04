package analyzer;

import java.io.IOException;

import parser.util.java.CurlyBraces;
import util.Todo;

@Todo("todo")

public class Program {

	public static void main(String[] args) throws IOException {
		// Test t = new Test();
		String text = "{j{}s}{}";
		CurlyBraces b = new CurlyBraces(text);
		b.read();

	}

}
