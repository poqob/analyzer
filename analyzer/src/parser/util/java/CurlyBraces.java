package parser.util.java;

//takes string input and returns first-last braces character index

public class CurlyBraces {
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
	public CurlyBraces(String content) {
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

	// returns read data indexes according to input text.
	private int[] getRange() {
		return new int[] { firstBraceIndex, lastBraceIndex + 1 };
	};

	// returns read data.
	public String getBody() {
		return sb.substring(firstBraceIndex, lastBraceIndex + 1);
	};

	public String toString() {
		return "\nleft: " + left + "\nright: " + right + "\nfirstindex: " + firstBraceIndex + "\nlastindex: "
				+ lastBraceIndex + "\nbody:" + getBody();
	};
}
