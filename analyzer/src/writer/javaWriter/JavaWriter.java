package writer.javaWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import models.classes.java.JavaClass;
import models.functionAndComments.AFunctionWithComments;
import writer.AWriter;

public class JavaWriter extends AWriter {

	// comment output files (scope of homework)
	private File sFile;
	private File mFile;
	private File jFile;

	// string operation elements.
	private String temp = "";
	private final String divider = "\n--------------------------------------------------\n\n";
	private FileOutputStream outputStream;
	private BufferedWriter writer;
	private String expectedOutput = "";

	// constructor
	public JavaWriter(JavaClass clss) {
		super(clss);
	}

	// write files into given path via console argument
	@Override
	public void writeToFile(String path) throws IOException {

		// create files up to given output location.
		createFiles(path);
		cleanFiles();
		super.clss.getFunComs().forEach(fc -> _write(fc));
	}

	// write files into execute location
	@Override
	public void writeToFile() {
		createFiles();
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

	// create files with output path
	private void createFiles(String path) throws IOException {

		sFile = new File(path + "single_line_comments.txt");
		mFile = new File(path + "multi_line_comments.txt");
		jFile = new File(path + "javadoc_comments.txt");

		// if given path not exist then create directories and output files.
		if (!sFile.getParentFile().exists())
			sFile.getParentFile().mkdirs();
		if (!mFile.getParentFile().exists())
			mFile.getParentFile().mkdirs();
		if (!jFile.getParentFile().exists())
			jFile.getParentFile().mkdirs();
		/*
		 * if (!sFile.exists()) sFile.createNewFile(); if (!mFile.exists())
		 * mFile.createNewFile(); if (!jFile.exists()) jFile.createNewFile();
		 */

	}

	// create files into execute folder.
	private void createFiles() {
		sFile = new File("single_line_comments.txt");
		mFile = new File("multi_line_comments.txt");
		jFile = new File("javadoc_comments.txt");
	}

	// writing to file process
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

	// *****************************************************************************//
	// Write to Console Section
	// *****************************************************************************//
	// The format of output.
	// *****************************************************************************//

	/*----------------------------------------------------
		Fonksiyon: foksiyon adý
			Yorum: yorum(tek satýra sýðacak)
			Yorum: yorum
			Yorum: yorum
	----------------------------------------------------
		Fonksiyon: foksiyon adý
			Yorum: yorum
			Yorum: yorum
			Yorum: yorum
	----------------------------------------------------
		Fonksiyon: foksiyon adý
			Yorum: yorum
			Yorum: yorum
			Yorum: yorum
	----------------------------------------------------
		Fonksiyon: foksiyon adý
			Yorum: yorum
			Yorum: yorum
			Yorum: yorum
	----------------------------------------------------*/

	// obtains related classes functions and comments together under funcom list and
	// manages all of that.
	// the block
	/*----------------------------------------------------
	Fonksiyon: foksiyon adý
		Yorum: yorum(tek satýra sýðacak)
		Yorum: yorum
		Yorum: yorum
	----------------------------------------------------*/

	@Override
	public void writeToConsole() {
		expectedOutput += clss.getType() + ": " + clss.getName() + "\n";
		clss.getFunComs().forEach(fc -> {
			expectedOutput += _functionBlock(fc);
		});
		System.out.print(expectedOutput);
	}

	// block creator according to function with comments object.
	private String _functionBlock(AFunctionWithComments func) {
		String _result = "";
		_result += "\t" + func.getType() + ": " + func.getName() + "\n";
		_result += "\t\tnumber of single-line comments: " + func.getSingleComments().size() + "\n";
		_result += "\t\tnumber of multi-line comments: " + func.getMultiComments().size() + "\n";
		_result += "\t\tnumber of javadoc comments: " + func.getJavadocComments().size() + "\n";
		_result += divider;
		return _result;
	}

	// creates single line comment information line
	private String _single(AFunctionWithComments fc) {
		if (fc.getSingleComments().size() != 0) {
			temp = fc.getFunction().getType() + ": " + fc.getFunction().getName() + "\n";
			fc.getSingleComments().forEach(sc -> temp += "\t" + sc.getType() + ": {" + sc.getRange()[0] + ","
					+ sc.getRange()[1] + "}\n\t\t" + sc.getContent() + "\n");
		} else
			temp = "";
		return temp;
	};

	// creates multi line comment information line
	private String _multi(AFunctionWithComments fc) {
		if (fc.getMultiComments().size() != 0) {
			temp = fc.getFunction().getType() + ": " + fc.getFunction().getName() + "\n";
			fc.getMultiComments().forEach(sc -> temp += "\t" + sc.getType() + ": {" + sc.getRange()[0] + ","
					+ sc.getRange()[1] + "}\n\t\t" + sc.getContent().replace('\n', ' ') + "\n");
		} else
			temp = "";
		return temp;
	};

	// creates javadocument comment information line
	private String _javadoc(AFunctionWithComments fc) {
		if (fc.getJavadocComments().size() != 0) {
			temp = fc.getFunction().getType() + ": " + fc.getFunction().getName() + "\n";
			fc.getJavadocComments().forEach(sc -> temp += "\t" + sc.getType() + ": {" + sc.getRange()[0] + ","
					+ sc.getRange()[1] + "}\n\t\t" + sc.getContent().replace('\n', ' ') + "\n");
		} else
			temp = "";
		return temp;
	};

}
