# Java Code Analyzer

A sophisticated Java code parser and analyzer that extracts class structure, functions (methods and constructors), and comments from Java source files.

## Overview

This tool parses Java source files to extract and analyze:
- Class structure and information
- Methods and constructors with their signatures
- Different types of comments (single-line, multi-line, and Javadoc)
- Relationships between code elements and their associated comments

The analyzer is built with extensibility in mind, featuring an architecture that could support additional programming languages in future versions.

## Features

- **Class Analysis**: Identifies and extracts class structures with their properties
- **Function Detection**: Parses both methods and constructors
- **Comment Analysis**: Detects and categorizes:
  - Single-line comments (`//`)
  - Multi-line comments (`/* */`)
  - Javadoc comments (`/** */`)
- **Output Options**:
  - Console output with various detail levels
  - File output of parsed comments (single-line, multi-line, and Javadoc)
- **Flexible Execution Modes**:
  - Regular mode: Output to files and console
  - Debug mode: Detailed analysis information
  - Show mode: Only console output
  - Method/Constructor specific output

## Usage

### Basic Usage

```bash
java -jar codeparser.jar MyClass.java
```

This will parse the Java file, output a summary to the console, and create three files in the current directory:
- `single_line_comments.txt`
- `multi_line_comments.txt` 
- `javadoc_comments.txt`

### Command Line Arguments

The analyzer supports various command-line arguments:

```
java -jar codeparser.jar [file] [options]
```

| Command | Description |
|---------|-------------|
| `java -jar codeparser.jar` | No arguments; displays error message |
| `java -jar codeparser.jar -h/--help` | Displays help information |
| `java -jar codeparser.jar -a/--about` | Shows information about the program |
| `java -jar codeparser.jar example.java` | Parses the specified file and outputs to console and files |
| `java -jar codeparser.jar example.java outputPath/` | Specifies output directory for comment files |
| `java -jar codeparser.jar example.java -d/--debug` | Runs in debug mode with detailed output |
| `java -jar codeparser.jar example.java -s/--show` | Only outputs to console (no files) |
| `java -jar codeparser.jar example.java -s -c/--constructor` | Shows only constructors |
| `java -jar codeparser.jar example.java -s -m/--methods` | Shows only methods |

## Output Format

### Console Output

The console output provides a summary of the analyzed class:

```
CLASS: MyClass
    METHOD: methodName
        number of single-line comments: X
        number of multi-line comments:  Y
        number of javadoc comments:     Z
    --------------------------------------------------
    CONSTRUCTOR: MyClass
        number of single-line comments: X
        number of multi-line comments:  Y
        number of javadoc comments:     Z
    --------------------------------------------------
```

### File Output

Three separate files are generated for each type of comment:

1. `single_line_comments.txt`: Contains all single-line comments
2. `multi_line_comments.txt`: Contains all multi-line comments 
3. `javadoc_comments.txt`: Contains all Javadoc comments

Each file includes the function name, location information, and the comment content.
