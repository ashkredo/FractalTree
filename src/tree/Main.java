/**
 *
 *  @author Shkred Artur
 *
 */

package tree;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] arguments) {
		int height = Integer.parseInt(JOptionPane.showInputDialog("Enter the height:"));
		new GUI(height);
	}
	
}
