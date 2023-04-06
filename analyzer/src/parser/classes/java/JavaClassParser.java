package parser.classes.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.AClass;
import models.classes.java.JavaClass;
import parser.classes.AClassParser;
import parser.patterns.java.GetPatern;
import parser.patterns.java.Paterns;
import parser.util.java.CurlyBraces;

public class JavaClassParser extends AClassParser {
	// fields
	private JavaClass clss;
	private String _name;
	private static String __name;
	private final String _pure;
	private static String _head;

	public JavaClassParser(String path) {
		this._name = _getName(path);
		_pure = find(path).toString();

	}

	// parse class block
	private static StringBuilder find(String dir) {

		// pattern
		Paterns p = Paterns.classes;

		GetPatern.className = __name;
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
					_head = matcher.group();
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
			br0.close();
		} catch (

		IOException e) {
			e.printStackTrace();
		}

		return sb;
	}

	// returns first line of clas definition without curly brace
	private static String getHead() {
		return _head.substring(0, _head.length() - 1);
	}

	// returns class name
	private static String _getName(String _dir) {
		StringBuilder _allClass = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(_dir))) {
			String line;

			// dedect which line is start of our scope
			while ((line = br.readLine()) != null) {
				_allClass.append(line);
			}

			br.close();

		} catch (

		IOException e) {
			e.printStackTrace();
		}

		String head = _allClass.toString();
		int _start = head.indexOf("class") + 6;
		int _stop = head.indexOf("{");
		__name = head.substring(_start, _stop).trim();
		return __name;
	}

	// takes input file pure text and turns into AClass object
	@Override
	public AClass parseClass() {
		CurlyBraces brc = new CurlyBraces(_pure);

		String struct = getHead() + brc.getBody();

		clss = new JavaClass(_name, struct);
		return clss;
	}

}
