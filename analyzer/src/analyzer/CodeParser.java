/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 04.04.23
* @CodeParser main
* CodeParser is second semester's first homework, scope of the homework
* was will of parsing java class and monitoring them on console and also 
* file system. My program able to do that but i wanted to do something more usefull and tough.
* first of all i have fulfilled my duties. secondly  i made a tool that can parse other language classes as well.
* my design promises to parse other languages classes but in line with the target and other life stuffs program only 
* supports java for now. I believe i've developed a tool that based on oop basics, well documanted, growable, modular, readable. :D 
* 
* 
* note to future: To provide new language support, you folow the flow:
* flow: 
* 1)define language components under model package. classes, functions, comment structures etc.
* 2)define language parser methods and code them language specific. class parser, function pars..
* 3)add launch conditions to Handler package and sub packages.			its all you are good to go :D
*/

package analyzer;

import handler.program.Handler;
import util.Todo;

@Todo("if a real function have commeted and located in a comment but classified as a function!!!!")
//arguments//
//java -jar test.jar 
//java -jar test.jar [-h, --help](optional) : prints to screen possible launch parameters
//java -jar test.jar [--about](optional) : prints to screen readme file content.
//java -jar test.jar [test.java](required) : input file path
//java -jar program.jar [example.java](required) [output path](optional) : path must be in this format -without quotes- "output\\"
//java -jar program.jar [example.java](required) [-d, --debug](optional) :(debug mode), only gives console output with detailed information.
//java -jar program.jar [example.java](required) [-s, --show] (optional) : writes output only to console.
//java -jar program.jar [example.java](required) [-s, --show] (required) [-c, --constructor] (optional) : writes constructors of the input file to console
//java -jar program.jar [example.java](required) [-s, --show] (required) [-m, --methods] (optional) : writes methods of input file to console

public class CodeParser {

	public static void main(String[] args) throws Throwable {

		Handler.handle(args);
	}

}
