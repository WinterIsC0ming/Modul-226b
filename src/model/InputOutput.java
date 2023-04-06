package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import controller.Controller;

/**
 * In dieser Klasse werden input und output Methoden verwaltet
 * @author Tommy Winter
 *
 */
public class InputOutput {

	/**
	 *Schreibt Daten in die Project.txt datei
	 */
	public void writer() {
		try (FileOutputStream fos = new FileOutputStream("Project.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(Controller.getProjects());

		} catch (FileNotFoundException e1) {
			throw new RuntimeException(e1);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
