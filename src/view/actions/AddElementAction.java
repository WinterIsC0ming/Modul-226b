package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import controller.Controller;

public class AddElementAction extends XAbstractAction{

	public AddElementAction(Controller controller) {
		super(controller);
		
		putValue(NAME,"Add");
		putValue(SHORT_DESCRIPTION,"Add");
		putValue(MNEMONIC_KEY,KeyEvent.VK_X);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.addElement();
		
	}


}
