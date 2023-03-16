package view.actions;

import javax.swing.Action;

import controller.Controller;

public class Actions {
	
	private Action exitAction;
	private Action searchAction;
	private Action addAction;
	private Action removeAction;
	
	public Actions(Controller controller) {
		exitAction = new ExitAction(controller);
		addAction = new AddElementAction(controller);
		searchAction = new SearchAction(controller);
		removeAction = new RemoveElementAction(controller);
	}
	
	public Action getExitAction() {
		return exitAction;
	}
	
	public Action getAddAction() {
		return addAction;
	}
	
	public Action getRemoveAction() {
		return removeAction;
	}
	
	public Action getSearchAction() {
		return searchAction;
	}

}
