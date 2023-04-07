/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @JavaCurlyBraces
* JavaCurlyBraces dedects and returns outer curly-brace structures. it may be 
* a class, a method, a constructor... anything which uses opening curly brace and closing curly brace. 
* 
*/

package parser.util.java;

//takes string input and returns first-last braces character index

public class JavaCurlyBraces {
	// content will be read.
	private final char[] charArray;
	// left and right curly braces count
	private int left = 0;
	private int right = 0;

	// braces indexes
	private int lastBraceIndex = -1;
	private int firstBraceIndex = -1;

	// contains body of the content that read by _read().
	private StringBuilder sb = new StringBuilder();

	// constructor
	// content is the start of a method-function-class any struct which made of
	// curly braces. end of the dedect process, getBody() returns outermost struct.
	public JavaCurlyBraces(String content) {
		this.charArray = content.toCharArray();
		_read();
	}

	// reads character array and counts '{','}' braces.
	private void _read() {

		for (char c : charArray) {
			sb.append(c);
			lastBraceIndex++;
			// counter counts
			if (c == '{') {
				left++;
				if (firstBraceIndex == -1)
					firstBraceIndex = lastBraceIndex;
			} else if (c == '}') {
				right++;
				if (left == right)
					break;
			}
		}
	};

	// returns read data.
	public String getBody() {
		return sb.substring(firstBraceIndex, lastBraceIndex + 1);
	};

	// body with statics, how many braces are there, first-last braces indexes.
	public String toString() {
		return "\nleft: " + left + "\nright: " + right + "\nfirstindex: " + firstBraceIndex + "\nlastindex: "
				+ lastBraceIndex + "\nbody:" + getBody();
	};
}
