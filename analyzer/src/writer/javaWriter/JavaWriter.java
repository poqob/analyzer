package writer.javaWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import models.classes.java.JavaClass;
import models.function.java.JavaConstructor;
import models.functionAndComments.AFunctionWithComments;
import util.Todo;
import writer.AWriter;

public class JavaWriter extends AWriter {

	private String expectedOutput = "";
	private File sFile = new File("other\\single_line_comments.txt");
	private File mFile = new File("other\\multi_line_comments.txt");
	private File jFile = new File("other\\javadoc_comments.txt");
	private String temp = "";
	private final String divider = "\n--------------------------------------------------\n\n";
	private FileOutputStream outputStream;
	private BufferedWriter writer;

	public JavaWriter(JavaClass clss) {
		super(clss);
	}

	@Todo("default path-given path applications")

	@Override
	public void writeToFile() {
		cleanFiles();
		super.clss.getFunComs().forEach(fc -> _write(fc));
	}

	// cleans comment files content if they are exist.
	@Override
	protected void cleanFiles() {
		FileWriter _fwriter;
		try {
			_fwriter = new FileWriter(sFile);
			_fwriter.write("");
			_fwriter.close();
			_fwriter = new FileWriter(mFile);
			_fwriter.write("");
			_fwriter.close();
			_fwriter = new FileWriter(jFile);
			_fwriter.write("");
			_fwriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void _write(AFunctionWithComments fc) {
		String _res;
		try {
			Write_single_line_comments:
			// Create a new file output stream to write data to the file
			outputStream = new FileOutputStream(sFile, true);

			// Create a new buffered writer to write text to the file
			writer = new BufferedWriter(new OutputStreamWriter(outputStream));

			// Write some text to the file
			_res = _single(fc);
			writer.write(_res != "" ? _res.concat(divider) : "");

			// Close the writer to flush and close the stream
			writer.close();

			Write_multi_line_comments:
			// ***************************************************************************************
			// Create a new file output stream to write data to the file
			outputStream = new FileOutputStream(mFile, true);

			// Create a new buffered writer to write text to the file
			writer = new BufferedWriter(new OutputStreamWriter(outputStream));

			// Write some text to the file
			_res = _multi(fc);
			writer.write(_res != "" ? _res.concat(divider) : "");

			// Close the writer to flush and close the stream
			writer.close();

			Write_javadoc_comments:
			// ***************************************************************************************
			// Create a new file output stream to write data to the file
			outputStream = new FileOutputStream(jFile, true);

			// Create a new buffered writer to write text to the file
			writer = new BufferedWriter(new OutputStreamWriter(outputStream));

			// Write some text to the file
			_res = _javadoc(fc);
			writer.write(_res != "" ? _res.concat(divider) : "");

			// Close the writer to flush and close the stream
			writer.close();

		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}

	}

	private String _single(AFunctionWithComments fc) {
		if (fc.getSingleComments().size() != 0) {
			temp = fc.getFunction().getType() + ": " + fc.getFunction().getName() + "\n";
			fc.getSingleComments().forEach(sc -> temp += "\t" + sc.getType() + ": {" + sc.getRange()[0] + ","
					+ sc.getRange()[1] + "}\n\t\t" + sc.getContent() + "\n");
		} else
			temp = "";
		return temp;
	};

	private String _multi(AFunctionWithComments fc) {
		if (fc.getMultiComments().size() != 0) {
			temp = fc.getFunction().getType() + ": " + fc.getFunction().getName() + "\n";
			fc.getMultiComments().forEach(sc -> temp += "\t" + sc.getType() + ": {" + sc.getRange()[0] + ","
					+ sc.getRange()[1] + "}\n\t\t" + sc.getContent().replace('\n', ' ') + "\n");
		} else
			temp = "";
		return temp;
	};

	private String _javadoc(AFunctionWithComments fc) {
		if (fc.getJavadocComments().size() != 0) {
			temp = fc.getFunction().getType() + ": " + fc.getFunction().getName() + "\n";
			fc.getJavadocComments().forEach(sc -> temp += "\t" + sc.getType() + ": {" + sc.getRange()[0] + ","
					+ sc.getRange()[1] + "}\n\t\t" + sc.getContent().replace('\n', ' ') + "\n");
		} else
			temp = "";
		return temp;
	};

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
		_result += divider;
		return _result;
	}

}
