package clientController;

import javax.swing.JFrame;

import view.AddWindow;

/**
 * The controller for the Add Window of the GUI
 * @author Aaron Dalik
 *
 */

public class AddWindowController extends GUIController{

	public AddWindowController(AddWindow view, CommControl com) {
		super(view, com);
		// TODO Auto-generated constructor stub
		view.addAddListener(new Button1Listener());
		view.addCancelListener(new Button2Listener());
		
	}
	
	@Override
	public void button2() {
		theView.setVisible(false);
	}

	
	
}
