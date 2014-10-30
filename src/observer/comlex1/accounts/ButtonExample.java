package observer.comlex1.accounts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonExample extends JFrame implements ActionListener {
	private JButton btn = new JButton("Raw Data");
	private JPanel panel = new JPanel();
	private ButtonModel model;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ButtonExample be = new ButtonExample();
		Container c = be.getContentPane();
		be.btn.setBackground(Color.RED);
		be.btn.addActionListener(be);
		be.panel.add(be.btn);
		c.add(be.panel);
		be.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		be.setBounds(50,50,200,250);
		be.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent ae) {
		if( btn.getBackground().equals(Color.RED)) {
			btn.setBackground(Color.BLUE);
		} else {
			btn.setBackground(Color.RED);
		}
		model = new DefaultButtonModel();
		//btn.setModel()
		
	}

}
