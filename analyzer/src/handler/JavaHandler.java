/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 08.04.23
* @JavaHandler
* JavaHandler is a language handler. it handles all situations of run styles for java files.
* this can be written more accurate to be realistic.
*/
package handler;

import java.io.IOException;

import handler.program.ProgramMode;
import models.classes.java.JavaClass;
import parser.java.JavaParser;
import util.Debug;
import writer.javaWriter.JavaWriter;

public class JavaHandler {
	// fields
	static JavaParser parser;
	static JavaClass clss;
	static JavaWriter writer;

	// run with different program modes according to input parameters.
	public static void handle(String path, ProgramMode mode) throws Exception {
		_initialize(path);
		if (mode == ProgramMode.regular)
			_regular();

		if (mode == ProgramMode.debug)
			_debug(path);

		if (mode == ProgramMode.show)
			_onlyShowOnConsole(path);

		if (mode == ProgramMode.showConstructors)
			_onlyShowConstructorsOnConsole(path);

		if (mode == ProgramMode.showMethods)
			_onlyShowMethodsOnConsole(path);
	}

	private static void _onlyShowMethodsOnConsole(String path) {
		writer.writeToConsoleOnlyMethods();
	}

	private static void _onlyShowConstructorsOnConsole(String path) {
		writer.writeToConsoleOnlyConstructors();

	}

	// initializing fields
	private static void _initialize(String path) throws Exception {
		parser = new JavaParser(path);
		clss = parser.parse();
		writer = new JavaWriter(clss);
	}

	// write to given output path and console
	public static void handle(String path, String output) throws Exception {
		_initialize(path);
		_regular(output);
	}

	// write to console and write comments to wanted location.
	private static void _regular(String output) throws IOException {
		writer.writeToConsole();
		writer.writeToFile(output);
	}

	// write to console and write comments to execute folder.
	private static void _regular() throws IOException {
		writer.writeToConsole();
		writer.writeToFile();
	}

	// debug mode shows various informations about class which was read.
	private static void _debug(String path) {
		writer.writeToConsole();
		Debug.Writer(clss.getStatics().concat("\n\n"));
		Debug.Writer(clss.toString().concat("\n\n"));
		Debug.Writer(clss.getFunComs());
	}

	// the difference of this method from _debug is that is shows less information
	// about class. Summery of class in human lannguage.
	private static void _onlyShowOnConsole(String path) {
		writer.writeToConsole();
	}

}
