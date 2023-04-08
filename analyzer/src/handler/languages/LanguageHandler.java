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

	private static void _java(String path, Mode mode) throws Exception {
		JavaHandler.handle(path, mode);
	}

	private static void _java(String path, String output) throws Exception {
		JavaHandler.handle(path, output);
	}

	// example
	private static void _dart() {
	}

}
