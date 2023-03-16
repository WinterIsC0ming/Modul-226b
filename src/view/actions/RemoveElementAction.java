package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import controller.Controller;

public class RemoveElementAction extends XAbstractAction{

	public RemoveElementAction(Controller controller) {
		super(controller);
		
		putValue(NAME,"Remove");
		putValue(SHORT_DESCRIPTION,"Remove");
		putValue(MNEMONIC_KEY,KeyEvent.VK_X);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F6,0));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.removeElement();
		
	}


}
