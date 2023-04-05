package parser.comment.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.java.JavaClass;
import models.comment.AComment;
import models.comment.java.JavaMultiComment;
import models.comment.java.JavaSingleComment;
import models.comment.java.JavadocComment;
import parser.comment.ACommentParser;
import parser.patterns.java.GetPatern;
import parser.patterns.java.Paterns;

public class JavaCommentParser extends ACommentParser {

	public JavaCommentParser(JavaClass clss) {
		super(clss);
	}

	private void _find() {

		// single comments
		_single();
		_multiComment();
		_javadocComment();

	};

	// turn class into bufferedReader inorder to read line by line.
	// line by line is neccessary to dedect single line comments.
	private void _single() {
		String str = super.clss.toString();
		BufferedReader reader = new BufferedReader(new StringReader(str));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				// send lines to single line comment dedector.
				_singleComment(line);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// dedects single line comments
	private void _singleComment(String line) {

		Paterns p = Paterns.single;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(line);

		int _startIndex = 0;
		String match = "";

		while (matcher.find()) {
			match = matcher.group();
			_startIndex = super.clss.toString().indexOf(match);
			super.comments.add(new JavaSingleComment(new int[] { _startIndex, match.length() + _startIndex }, match));
		}

	}

	// dedects multi line java comments
	private void _multiComment() {
		Paterns p = Paterns.multi;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(clss.toString());
		int _startIndex = 0;
		String match = "";

		while (matcher.find()) {
			match = matcher.group();
			_startIndex = super.clss.toString().indexOf(match);
			super.comments.add(new JavaMultiComment(new int[] { _startIndex, match.length() + _startIndex }, match));
		}
	}

	// dedects javadoc comments
	private void _javadocComment() {
		Paterns p = Paterns.javadoc;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(clss.toString());
		int _startIndex = 0;
		String match = "";

		while (matcher.find()) {
			match = matcher.group();
			_startIndex = super.clss.toString().indexOf(match);
			super.comments.add(new JavadocComment(new int[] { _startIndex, match.length() + _startIndex }, match));
		}
	}

	@Override
	public ArrayList<AComment> parse() {
		_find();
		return super.comments;
	}

}
