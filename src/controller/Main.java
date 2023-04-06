package controller;

import javax.swing.SwingUtilities;
/**
 * In der Main Klasse wird nur der Controller aufgerufen
 * @author Tommy Winter
 */
public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new Controller();
			}
		});

	}

}
