package handler.languages;

import java.io.IOException;

import handler.program.Mode;
import models.classes.java.JavaClass;
import parser.java.JavaParser;
import util.Debug;
import writer.javaWriter.JavaWriter;

public class JavaHandler {
	static JavaParser parser;
	static JavaClass clss;
	static JavaWriter writer;

	public static void handle(String path, Mode mode) throws Exception {
		_initialize(path);
		if (mode == Mode.regular)
			_regular(path);

		if (mode == Mode.debug)
			_debug(path);
	}

	public static void handle(String path, String output) throws Exception {
		_initialize(path);
		_regular(path, output);
	}

	private static void _initialize(String path) throws Exception {
		parser = new JavaParser(path);
		clss = parser.parse();
		writer = new JavaWriter(clss);
	}

	private static void _regular(String path, String output) throws IOException {
		writer.writeToConsole();
		writer.writeToFile(output);
	}

	private static void _regular(String path) throws IOException {
		parser = new JavaParser(path);
		clss = parser.parse();
		writer = new JavaWriter(clss);
		writer.writeToConsole();
		writer.writeToFile();
	}

	private static void _debug(String path) {
		writer.writeToConsole();
		Debug.Writer(clss.getStatics().concat("\n\n"));
		Debug.Writer(clss.toString().concat("\n\n"));
		Debug.Writer(clss.getFunComs());
	}
}
