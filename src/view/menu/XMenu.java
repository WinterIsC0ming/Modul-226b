package view.menu;

import javax.swing.Action;
import javax.swing.JMenu;

public class XMenu extends JMenu{
	
	public XMenu() {
		
	}
	
	public XMenu(String s) {
		super(s);
	}
	
	public XMenu(Action a) {
		super(a);
	}
	
	public XMenu(String s, boolean b) {
		super(s, b);
	}
	
	public XMenu(String name, char m) {
		this(name);
		setMnemonic(m);
	}
	

}
