package parser.util.java;

//takes string input and returns first-last braces character index

public class CurlyBraces {
	// content will be read.
	private final char[] charArray;
	// left and right curly braces count
	private int left = 0;
	private int right = 0;

	//
	private int lastBraceIndex = 0;

	public CurlyBraces(String content) {
		this.charArray = content.toCharArray();
	}

	public void read() {
		for (char c : charArray) {
			lastBraceIndex++;
			System.out.print(c);
			// counter counts
			if (c == '{') {
				left++;
			} else if (c == '}') {
				right++;
				if (left == right) {
					break;
				}
			}
		}
		result();
	};

	public void result() {
		System.out.print("\nleft: " + left + "\nright: " + right + "\nlastindex: " + lastBraceIndex);
	};
}
