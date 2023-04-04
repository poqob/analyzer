package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parser.patterns.java.GetPatern;
import parser.patterns.java.Paterns;

public class Test {

	public Test() {
		String path = currPath().toAbsolutePath().toString().concat("\\src\\test\\test.txt");
		_read(path);

	}

	public static Path currPath() {
		Path currentDir = Paths.get("");
		return currentDir;

	}

	public static void _read(String dir) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");

				_readClassData(line);
				_singleComment(line);

			}

			_multiComment(sb.toString());
			_javadocComment(sb.toString());
			_methodDedect(sb.toString());
			_constructorDedect(sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void _singleComment(String line) {
		Paterns p = Paterns.single;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(line);

		while (matcher.find()) {
			_writer("single-line comment : " + matcher.group() + "\n");
		}
	}

	public static void _multiComment(String content) {
		Paterns p = Paterns.multi;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(content);

		int count = 0;
		while (matcher.find()) {
			count++;
			_writer("Multi-line comment " + count + ": " + matcher.group() + "\n");
		}
	}

	public static void _javadocComment(String content) {
		Paterns p = Paterns.javadoc;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(content);

		int count = 0;
		while (matcher.find()) {
			count++;
			_writer("javadoc comment " + count + ": " + matcher.group() + "\n");
		}
	}

	public static void _methodDedect(String content) {
		Paterns p = Paterns.method;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(content);

		int count = 0;
		while (matcher.find()) {

			count++;
			_writer("method: " + count + ": " + matcher.group() + "\n");
		}
	}

	public static void _readClassData(String line) {
		// class name
		Paterns p = Paterns.classes;
		Pattern pa = GetPatern.getPatern(p);
		String ex = "public class Test{";
		Matcher matcher = pa.matcher(line);

		while (matcher.find()) {
			_writer("class: " + matcher.group() + "\n");
		}
	}

	public static void _constructorDedect(String content) {
		Paterns p = Paterns.constructor;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(content);

		int count = 0;
		while (matcher.find()) {
			_writer("constructor: " + ++count + ": " + matcher.group() + "\n");
		}
	}

	public static void _writer(String message) {
		System.out.print(message);
	}

	public static void _writer(Long message) {
		System.out.print(message);
	}

	public static void _writer(int message) {
		System.out.print(message);
	}

}
