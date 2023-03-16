package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import controller.Controller;

public class SearchAction extends XAbstractAction{

	public SearchAction(Controller controller) {
		super(controller);
		
		putValue(NAME,"Search");
		putValue(SHORT_DESCRIPTION,"Search");
		putValue(MNEMONIC_KEY,KeyEvent.VK_X);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F7,0));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.searchElement();
		
	}


}
