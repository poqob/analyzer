package parser.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.AClass;
import models.classes.JavaClass;
import parser.patterns.java.GetPatern;
import parser.patterns.java.Paterns;
import parser.util.java.CurlyBraces;
import util.Todo;

public class JavaClassParser extends AClassParser {
	// fields
	private JavaClass clss;
	private final String dir;
	private final String name;
	private final String pure;
	private static String head;

	@Todo("accepts only absolut path i have to fix this ")
	public JavaClassParser(String path) {
		this.dir = path;
		pure = find(path).toString();
		this.name = getName();

	}

	// parse class block
	private static StringBuilder find(String dir) {

		// pattern
		Paterns p = Paterns.classes;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = null;
		StringBuilder sb = new StringBuilder();
		// line counter
		int lineCount = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
			String line;

			// dedect which line is start of our scope
			while ((line = br.readLine()) != null) {
				lineCount++;
				matcher = pa.matcher(line);
				if (matcher.find()) {
					// attemt head line of class
					head = matcher.group();
					break;
				}
			}

			br.close();
			// new buffer to read from scratch
			BufferedReader br0 = new BufferedReader(new FileReader(dir));

			while ((line = br0.readLine()) != null) {

				if (lineCount <= 1)
					sb.append(line + "\n");
				else
					lineCount--;

			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}

		return sb;
	}

	// returns first line of clas definition without curly brace
	public static String getHead() {
		return head.substring(0, head.length() - 1);
	}

	// returns class name
	private static String getName() {
		String _head = head;
		int _start = _head.indexOf("class") + 6;
		int _stop = _head.indexOf("{");
		return _head.substring(_start, _stop);
	}

	@Override
	public AClass parse() {
		CurlyBraces brc = new CurlyBraces(pure);

		String struct = getHead() + brc.getBody();

		clss = new JavaClass(getName(), struct);
		return clss;
	}

}
