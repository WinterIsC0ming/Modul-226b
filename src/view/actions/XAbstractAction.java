package view.actions;

// import java.net.URL;

import javax.swing.AbstractAction;
// import javax.swing.ImageIcon;

import controller.Controller;

public abstract class XAbstractAction extends AbstractAction{
	
	protected Controller controller;
	
	public XAbstractAction(Controller controller) {
		this.controller = controller;
	}
	
	//protected ImageIcon buildImageIcon(String location) {
	//	URL imageURL = XAbstractAction.class.getResource(location);
	//	return imageURL == null ? null : new ImageIcon(imageURL);
	//}
}
