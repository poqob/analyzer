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
			Writer(fc.getSingleComments().isEmpty() ? "" : "\n\t\tSINGLE " + fc.getName().concat("\n"));
			fc.getSingleComments().forEach(sc -> Writer(sc.toString() + "\n"));

			Writer(fc.getMultiComments().isEmpty() ? "" : "\n\t\tMULTI " + fc.getName().concat("\n"));
			fc.getMultiComments().forEach(sc -> Writer(sc.toString() + "\n"));

			Writer(fc.getJavadocComments().isEmpty() ? "" : "\n\t\tDOCUMENT " + fc.getName().concat("\n"));
			fc.getJavadocComments().forEach(sc -> Writer(sc.toString() + "\n"));

			Writer("\n******************************************************\n");

		});
	}

}
