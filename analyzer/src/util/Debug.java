/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @Debug
* Debug class contains write (console) methods. i was lazy to write every time System.out......
* 
*/

package util;

import java.util.ArrayList;

import models.functionAndComments.AFunctionWithComments;

public class Debug {

	public static void Writer(String message) {
		System.out.print(message);
	}

	public static void Writer(Long message) {
		System.out.print(message);
	}

	public static void Writer(int message) {
		System.out.print(message);
	}

	public static void Writer(ArrayList<AFunctionWithComments> funcomms) {
		funcomms.forEach(fc -> {
			Writer(fc.getSingleComments().isEmpty() ? "" : fc.getName().concat("\n"));
			fc.getSingleComments().forEach(sc -> Writer(sc.toString() + "\n"));
			// fc.getJavadocComments().forEach(sc -> Writer(sc.toString() + "\n"));

		});
	}

}
