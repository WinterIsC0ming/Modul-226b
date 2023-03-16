package view.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import controller.Controller;
import view.actions.Actions;

public class MainMenuBar extends JMenuBar {
	private final Controller controller;
	private final Actions actions;
	
	public MainMenuBar(Controller controller) {
		this.controller = controller;
		actions = controller.getActions();
		
		add(buildFileMenu());
		add(buildEditMenu());
	}

	private JMenu buildFileMenu() {
		
		XMenu m = new XMenu("File", 'F');
		m.add(actions.getExitAction());	
		
		return m;
	}
	
	private JMenu buildEditMenu() {
		
		XMenu m = new XMenu("Edit", 'E');
		m.add(actions.getAddAction());
		m.add(actions.getRemoveAction());
		m.add(actions.getSearchAction());
		
		return m;
	}

}
