package analyzer.writer.java;

import analyzer.writer.AWriter;
import models.classes.AClass;
import models.function.java.JavaConstructor;
import models.functionAndComments.AFunctionWithComments;
import util.Todo;

public class JavaWriter extends AWriter {
	private String expectedOutput = "";

	public JavaWriter(AClass clss) {
		super(clss);
	}

	@Todo("File operations!")
	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeToConsole() {
		expectedOutput += clss.getType() + ": " + clss.getName() + "\n";
		clss.getFunComs().forEach(fc -> {
			expectedOutput += _functionBlock(fc);
		});
		System.out.print(expectedOutput);
	}

	private String _functionBlock(AFunctionWithComments func) {
		String _type;
		if (func.getFunction() instanceof JavaConstructor)
			_type = "CONSTRUCTOR";
		else
			_type = "METHOD";

		String _result = "";
		_result += "\t" + _type + ": " + func.getName() + "\n";
		_result += "\t\tnumber of single-line comments: " + func.getSingleComments().size() + "\n";
		_result += "\t\tnumber of multi-line comments: " + func.getMultiComments().size() + "\n";
		_result += "\t\tnumber of javadoc comments: " + func.getJavadocComments().size() + "\n";
		_result += "--------------------------------------------------\n";
		return _result;
	}

}
