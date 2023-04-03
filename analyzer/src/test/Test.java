package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
			String line;

			while ((line = br.readLine()) != null) {
				_singleComment(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void _singleComment(String line) {
		Paterns p = Paterns.single;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(line);

		while (matcher.find()) {
			_writer(matcher.group().concat("\n"));
		}
	}

	public static void _writer(String message) {
		System.out.print(message);
	}

}
