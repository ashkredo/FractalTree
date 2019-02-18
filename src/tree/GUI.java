/**
 *
 *  @author Shkred Artur
 *
 */

package tree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GUI extends JFrame {
	
	private int heigth;
	
	public GUI(int height) {
		super("Fractal Tree");
		this.heigth = height;
		BorderLayout MasterPanelLayout = new BorderLayout();
		Container pane = getContentPane();
		pane.setLayout(MasterPanelLayout);
		setBounds(100, 100, 2000, 1000);
       		setResizable(false);		
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(pane);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);	
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==27) { System.exit(0); }
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) {
        	return;
        }
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        drawTree(g, (getWidth() / 2), (getHeight() + 10), -90, heigth);
    }

}
