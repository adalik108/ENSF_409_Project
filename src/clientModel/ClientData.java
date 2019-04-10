package clientModel;

import java.util.ArrayList;

import model.Tool;
import view.MainWindow;

public class ClientData {

	private ArrayList<Tool> tools;
	
	public ClientData() {
		tools = new ArrayList<Tool>();
	}
	
	public ArrayList<Tool> getTools(){
		return tools;
	}
	
	public Tool getTool(int i) {
		return tools.get(i);
	}
	
	public String[] fullInfoString() {
		String[] s = new String[tools.size()];
		for(int i = 0; i < tools.size(); i++) {
			try {
				s[i] = tools.get(i).toString();
			}catch(NullPointerException e) {
				//s[i] = searchError(i);
				s[i] = ("Tool not found");
			}
		}
		//Don't display the same tool twice
		if(tools.size() > 1) {
			if(s[0].equals(s[1]))
				s[1] = "";
		}
		System.out.println(tools.size());
		return s;
	}
	
	public String[] quantInfoString() {
		String[] s = new String[tools.size()];
		for(int i = 0; i < tools.size(); i++) {
			try {
				s[i] = ("Name: " + tools.get(i).getName() + "  Quantity: " + tools.get(i).getQuant());
			}catch(NullPointerException e) {
				//s[i] = searchError(i);
				s[i] = ("Tool not found");
			}
		}
		//Don't display the same tool twice
		if(tools.size() > 1) {
			if(s[0].equals(s[1]))
				s[1] = "";
		}
		System.out.println(tools.size());
		return s;
	}
	
//	private String searchError(int i) {
//		String s = "";
//		if(i == 0) {
//			s += ("Tool: " + ((MainWindow) theView).getNameInput() + "could not be found");
//		}
//		else {
//			s += ("Tool: " + ((MainWindow) theView).getIdInput() + "could not be found");
//		}
//		return s;
//	}
	
	public void setTools(ArrayList<Tool> t) {
		tools = t;
	}
	
	
}
