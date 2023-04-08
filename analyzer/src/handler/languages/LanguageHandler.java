/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 08.04.23
* @LanguageHandler
* LanguageHandler, i confess this is a bit rushed. but works :D 
* language handler manages and directs flow of program. 
* runs program according to given parameters. some of them must be overriden up to entered parameters.
*/
package handler.languages;

import handler.extensions.Extensions;
import handler.program.Mode;

public class LanguageHandler {
	public static void handler(Extensions extension, String path, Mode mode) throws Exception {
		switch (extension) {
		case java:
			_java(path, mode);
			break;
		case dart:
			_dart();
			break;
		default:
			break;
		}
	}

	public static void handler(Extensions extension, String path, String output) throws Exception {
		switch (extension) {
		case java:
			_java(path, output);
			break;
		case dart:
			_dart();
			break;
		default:
			break;
		}
	}

	public static void handler(Extensions extension, String path) throws Exception {
		switch (extension) {
		case java:
			_java(path, Mode.show);
			break;
		case dart:
			_dart();
			break;
		default:
			break;
		}
	}

	// run java with modes, debug or regular.
	private static void _java(String path, Mode mode) throws Exception {
		JavaHandler.handle(path, mode);
	}

	// run java logic with regular mode but run with given output path.
	private static void _java(String path, String output) throws Exception {
		JavaHandler.handle(path, output);
	}

	// example of running other languages
	private static void _dart() {
	}

}
