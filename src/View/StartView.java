package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StartView extends JFrame {
	private JPanel panel; 
	private JTextArea text;
	public StartView(){
	this.setSize(700, 700);
	panel=new JPanel();
	panel.setPreferredSize(new Dimension(500,500));
	panel.setLayout(new GridLayout(0,1));
	this.add(panel,BorderLayout.CENTER);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	text=new JTextArea();
	text.setPreferredSize(new Dimension(500,500));
	text.setEditable(false);
	this.add(text,BorderLayout.NORTH);
	text.setText("HEARTHSTONE");
	this.setVisible(true);
	this.revalidate();
	this.repaint();
}
	public JPanel getPanel() {
		return panel;
	}
	public JTextArea getText() {
		return text;
	}
	
}
