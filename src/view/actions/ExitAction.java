package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import controller.Controller;

public class ExitAction extends XAbstractAction{

	public ExitAction(Controller controller) {
		super(controller);
		
		putValue(NAME,"Exit");
		putValue(SHORT_DESCRIPTION,"Exit App");
		//putValue(SMALL_ICON, buildImageIcon(""));
		putValue(MNEMONIC_KEY,KeyEvent.VK_X);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.exit();
		
	}


}
